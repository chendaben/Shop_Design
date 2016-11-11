package com.cyq.bookstore.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.pojo.Users;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.service.UsersService;

@Controller
@RequestMapping(value="/user")
public class UsersController {
	
	@Resource
	private UsersService usersService;
	
	@Resource
	private BooksService bookService;
	
	@Resource
	private CategoryService categoryService;
	
	private static Logger Log=LoggerFactory.getLogger(UsersController.class);

	/**
	 * 登录验证
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Users login(@RequestParam String UserPhone,
			@RequestParam String UserPassword,HttpSession session) {
		Users user = new Users();
		user.setUserphone(UserPhone);
		user.setUserpassword(UserPassword);
		if (usersService.selectUsers(user) != null) {
			user = usersService.selectUsers(user);
			System.out.println("能查到信息");
			session.setAttribute("userId", user.getUserid());
			return  user;
		}
        return null;


	}

    /**
     * 首页
     * @param usergrade（1：表示普通用户，2：是管理员）
     * @return
     */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ModelAttribute
	public ModelAndView userBookList(@RequestParam String usergrade){
	    if (usergrade.equals(1)){
            Map<String, Object> model = new HashMap<String, Object>();
            //书籍类别信息
            List<Category> categorylist=categoryService.selectAllCategory();
            model.put("categoryList", categorylist);
            //书籍信息
            List<Books> list = bookService.selectAllBook();
            model.put("bookList", list);
            return new ModelAndView("index", model);
        }else {
            return new ModelAndView("indexAdmin", null);
        }

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public void save(@RequestParam String username,@RequestParam String userpassword,@RequestParam String userphone,
			@RequestParam String useremail) {
		usersService.insertUser(username,userpassword,userphone,useremail);
	}


	/**
	 * 根据id得到用户个人信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/info",method=RequestMethod.GET)
	public Users getUserById(HttpSession session) {
		Integer userId=(Integer) session.getAttribute("userId");
		Users user=usersService.getUserById(userId);
		return user;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void updateUser(@RequestParam String username,@RequestParam String userpassword,@RequestParam String userphone,
			@RequestParam String useremail) {
		//usersService.updateUser(user);
		
	}
	/**
	 * 把书籍加入购物车
	 */
	@RequestMapping("/insertShopCart/{bookid}")
	public String insertShopCart(@PathVariable Integer bookid,HttpServletRequest request){
		//通过bookid得到book的详细信息
		Books book=bookService.selectBookById(bookid);
		//得到userid
		Users user=(Users) request.getSession().getAttribute("user");
		//构建shopbook对象，插入到购物车
		ShopBook shBook=new ShopBook(user.getUserid(),bookid);
		ShopBook shBookByCondition=usersService.getShopCartByCondition(shBook);
		if (shBookByCondition!= null) {
			// 如果购物车数据库中存在该书籍，则直接更新购物车价格
			ShopBook shBook1=new ShopBook();
			shBook1.setShopid(shBookByCondition.getShopid());
			shBook1.setOrdermount(shBookByCondition.getOrdermount()+1);
			shBook1.setPrice(shBookByCondition.getPrice().add(book.getBookprice()));
			usersService.updateByShopId(shBook1);
		} else {
			ShopBook shopBook = new ShopBook();
			shopBook.setBookid(bookid);
			shopBook.setUserid(user.getUserid());
			shopBook.setOrdermount(1);
			shopBook.setPrice(book.getBookprice());
			shopBook.setIspay("no");
			usersService.insetShopBook(shopBook);
		}
			
		//页面上应该给出提示，加入购物车成功（未做）
		//跳转页面未做好
		return "redirect:/index";
		
	}
	
	/**
	 * 跳转到购物车页面
	 */
	@RequestMapping("/shopCart")
	public String shopBook(Model model,HttpServletRequest request){
//		购物车中的数据也要翻页
		Users user=(Users) request.getSession().getAttribute("user");
		List<ShopBook> shopBooks=usersService.showShopBook(user.getUserid());
		model.addAttribute("shopBooks", shopBooks);
		return "shopCart";
	}
	/**
	 * 订单确认页面
	 */
	

}
