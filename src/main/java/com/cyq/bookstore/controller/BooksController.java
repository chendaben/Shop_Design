package com.cyq.bookstore.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.pojo.Users;
import com.cyq.bookstore.service.ShopCartService;
import com.cyq.bookstore.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.util.Pager;

@Controller
@RequestMapping(value="/book")
public class BooksController {
	
	@Resource
	private BooksService booksService;
	
	@Resource
	private CategoryService categoryService;

	@Resource
	private UsersService usersService;

	@Resource
	private ShopCartService shopCartService;
	

	/**
	 * 根据id删除书籍
	 */
	@RequestMapping(value="/{bookid}/delete",method =RequestMethod.DELETE)
	public int deleteBook(@PathVariable Integer bookid){
		 return  booksService.deleteBooks(bookid);
	}

	/**
	 * 列出所有书籍
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<Books> listBook(@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
						   @RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
						   @RequestParam(value = "name", required = false, defaultValue = "")String name){
		//根据书籍名称搜索
		List<Books> list=new ArrayList<Books>();
		if(StringUtils.isNotBlank(name)){
			Books book=new Books();
			for (Books b : booksService.selectAllBook()) {
				if (b.getBookname().toUpperCase().indexOf(name.toUpperCase()) != -1) {
					list.add(b);
				}
			}
		}else{
			list=booksService.selectAllBook();
		}
		Pager<Books> pager = new Pager<Books>(pageNo,pageSize,list);
		int pageSum=(list.size() +pageSize -1)/pageSize;
		return pager.getPagerObject();

	}


	/**
	 * 添加书籍
	 */
	@ResponseBody
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public int saveBook(@ModelAttribute Books book,HttpServletRequest request,BindingResult bindingResult){
		//上传文件保存方法
		List<MultipartFile> files=book.getImages();
		List<String> fileNames=new ArrayList<String>();
		if(null != files && files.size()>0){
			File imageFile=null;
			String fileName=null;
			for(MultipartFile multipartFile:files){
				fileName=multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				imageFile=new File(request.getServletContext().getRealPath("/resource/image/"),fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			String imageUrl="image/"+fileName;
			book.setImageUrl(imageUrl);
		}else{
			book.setImageUrl(null);
		}

		//保存书籍基本信息（目前只做成一张图片显示）
		return booksService.insert(book);
	}

	/**
	 * 更新书籍信息
	 */
	@ResponseBody
	@RequestMapping(value="/{id}/update",method=RequestMethod.PUT)
	public int updateBook(@ModelAttribute Books book){
		return booksService.updateBooks(book);
	}

	/**
	 * 根据书籍分类查询该类别下的书籍(待补充)
	 */
	@RequestMapping(value = "/book_category")
	public ModelAndView selectBookByCategoryId(Integer categoryid) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Books> list=new ArrayList<Books>();
		if(categoryid==null){
			list=booksService.selectAllBook();
		}else{
			list = booksService.selectBookByCategoryId(categoryid);
		}
		model.put("bookList", list);
		// 带入书籍类别信息
		List<Category> categorylist = categoryService.selectAllCategory();
		model.put("categoryList", categorylist);
		return new ModelAndView("index", model);
	}

	/**
	 * 把书籍加入购物车
	 */
	@ResponseBody
	@RequestMapping("/{bookid}/insertToShopCart")
	public String insertShopCart(@PathVariable Integer bookid, HttpSession session){
		//通过bookid得到book的详细信息
		Books book=booksService.selectBookById(bookid);
		//得到userid
		int userId=(Integer) session.getAttribute("userId");
		Users user=usersService.getUserById(userId);

		ShopBook shBook=new ShopBook(user.getUserid(),bookid);
		ShopBook shBookByCondition=shopCartService.getShopCartByCondition(shBook);
		if (shBookByCondition!= null) {
			// 如果购物车数据库中存在该书籍，则直接更新购物车价格
			ShopBook shBook1=new ShopBook();
			shBook1.setShopid(shBookByCondition.getShopid());
			shBook1.setOrdermount(shBookByCondition.getOrdermount()+1);
			shBook1.setPrice(shBookByCondition.getPrice().add(book.getBookprice()));
			shopCartService.updateByShopId(shBook1);
		} else {
			//构建shopbook对象，插入到购物车
			ShopBook shopBook = new ShopBook();
			shopBook.setBookid(bookid);
			shopBook.setUserid(user.getUserid());
			shopBook.setOrdermount(1);
			shopBook.setPrice(book.getBookprice());
			shopBook.setIspay("no");
			shopCartService.insetShopBook(shopBook);
		}

		//页面上应该给出提示，加入购物车成功（未做）
		//跳转页面未做好
		return "redirect:/index";

	}
	
	
}
