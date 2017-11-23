package com.cyq.bookstore.controller;
/**
 * 对用户的相关操作
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.pojo.Users;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.service.UsersService;
@Api(value = "用户列表")
@RestController
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Users login(@RequestParam String UserPhone,
			@RequestParam String UserPassword,HttpSession session) {
		Users user = new Users();
		user.setUserphone(UserPhone);
		user.setUserpassword(UserPassword);
		if (usersService.selectUsers(user) != null) {
			user = usersService.selectUsers(user);
			Log.info("能查到信息");
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
	public void userBookList(@RequestParam String usergrade){
	    if (usergrade.equals(1)){
            Map<String, Object> model = new HashMap<String, Object>();
            //书籍类别信息
            List<Category> categorylist=categoryService.selectAllCategory();
            model.put("categoryList", categorylist);
            //书籍信息
            List<Books> list = bookService.selectAllBook();
        }

	}

	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public int save(@RequestParam String username,@RequestParam String userpassword,@RequestParam String userphone,
			@RequestParam String useremail) {
		return usersService.insertUser(username,userpassword,userphone,useremail);
	}

	/**
	 * 展示所有用户信息
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Users> showUser(@RequestParam(required=false,defaultValue="1") int pageNow,@RequestParam(required=false,defaultValue="3") int pageSize){
		int totalCount=usersService.showAllCount();
		List<Users> userList=usersService.showUser(pageNow,pageSize);
		return userList;
	}


	/**
	 * 根据id删除用户
	 *
	 * @param userid
	 * @return
	 */
	@RequestMapping("/{userid}/delete")
	public int deleteUser(@PathVariable Integer userid) {

		return usersService.deleteUserById(userid);
	}


	/**
	 * 根据session中的id得到用户个人信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/info",method=RequestMethod.GET)
	public Users getUserBySession(HttpSession session) {
		Integer userId=(Integer) session.getAttribute("userId");
		Users user=usersService.getUserById(userId);
		return user;
	}

    /**
     * 根据 id得到个人信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/info",method=RequestMethod.GET)
    public Users getUserById(@PathVariable int id) {
        Users user=usersService.getUserById(id);
        return user;
    }

	/**
	 * 更新用户信息
	 *
	 */
	@RequestMapping(value="/{userid}/update",method=RequestMethod.POST)
	public void updateUser(@PathVariable int userid,@RequestParam String username,@RequestParam String userpassword,@RequestParam String userphone,
			@RequestParam String useremail) {
	    Users user=new Users();
        user.setUserid(userid);
        user.setUsername(username);
        user.setUserpassword(userpassword);
        user.setUserphone(userphone);
        user.setUseremail(useremail);
		usersService.updateUser(user);
		
	}


}
