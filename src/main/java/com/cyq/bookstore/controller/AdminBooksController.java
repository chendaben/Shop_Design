package com.cyq.bookstore.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.util.Pager;

@Controller
public class AdminBooksController {

	@Resource
	private BooksService booksService;

	@Resource
	private CategoryService categoryService;
	
	/**
	 * 跳转到添加书籍页面
	 */
	@RequestMapping(value="/book_input")
	public String inputBook(Model model){
		model.addAttribute("book", new Books());
		//获得书籍分类列表
		List<Category> categories=categoryService.selectAllCategory();
		model.addAttribute("categories", categories);
		return "bookInput";
	}
	
	/**
	 * 根据id删除书籍
	 */
	@RequestMapping(value="/book_delete/{bookid}")
	public String deleteBook(@PathVariable Integer bookid){
		booksService.deleteBooks(bookid);
		return "redirect:/book_list";
	}
	
	/**
	 * 列出所有书籍
	 */
	@RequestMapping(value="/book_list",method=RequestMethod.GET)
	public String listBook(Model model,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
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
		//带入书籍类别信息
		List<Category> categorylist=categoryService.selectAllCategory();
		model.addAttribute("categoryList", categorylist);
		Pager<Books> pager = new Pager<Books>(pageNo,pageSize,list);
		int pageSum=(list.size() +pageSize -1)/pageSize;
		model.addAttribute("pageSum",pageSum);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("bookList",pager.getPagerObject());
		model.addAttribute("allList", list.size());
		return "book";
	}
	
	/**
	 * 根据id跳转到更新书籍页面
	 */
	@RequestMapping(value="/book_edit")
	public String editBook(@RequestParam Integer bookid,Model model){
		//得到所有的类别信息供管理员选择
		List<Category> categorylist=categoryService.selectAllCategory();
		model.addAttribute("categoryList", categorylist);
		Books book=booksService.selectBookById(bookid);
		model.addAttribute("book", book);
		return "bookEdit";
	}
	
	/**
	 * 添加书籍
	 */
	@RequestMapping(value="/book_save")
	public String saveBook(@ModelAttribute Books book,HttpServletRequest request,BindingResult bindingResult){
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
		booksService.insert(book);
		return "redirect:/book_list";
	}
	
	/**
	 * 更新书籍信息
	 */
	@RequestMapping(value="/book_update")
	public String updateBook(@ModelAttribute Books book){
		booksService.updateBooks(book);
		return "redirect:/book_list";
	}
	
	
}
