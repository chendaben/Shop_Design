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
public class UsersController {
	
	@Resource
	private UsersService usersService;
	
	@Resource
	private BooksService bookService;
	
	@Resource
	private CategoryService categoryService;
	
	private static Logger Log=LoggerFactory.getLogger(UsersController.class);

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value = "/go_login")
	public String goLogin() {
		return "userLogin";
	}

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
			session.setAttribute("user", user);
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
	 * 跳转到注册页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/go_regist")
	public String regist(Model model) {
		model.addAttribute("user", new Users());
		return "userRegister";
	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String save(@ModelAttribute Users user, HttpServletRequest request) {
		
		if (usersService.selectUsers(user) == null) {
			usersService.insertUser(user);
			System.out.println("注册成功");
			return "userLogin";
		} else {
			request.setAttribute("error", "用户已存在");
			System.out.println("注册失败");
			return "userRegister";
		}

	}


	/**
	 * 根据id跳转到更新用户信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user_edit")
	public String editUser(Model model,HttpServletRequest request) {
		Users user=(Users) request.getSession().getAttribute("user");
		//Users user = usersService.getUserById(userid);
		model.addAttribute("user", user);
		return "userEdit";
	}

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user_update")
	public String updateUser(@ModelAttribute Users user) {
		usersService.updateUser(user);
		// 用户更新信息后跳转到详细页面（未写）
		return "redirect:/user_edit";
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
