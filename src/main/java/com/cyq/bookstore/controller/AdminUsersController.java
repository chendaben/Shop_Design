package com.cyq.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyq.bookstore.pojo.Users;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.service.UsersService;

@Controller
@RequestMapping("/admin/user")
public class AdminUsersController {
	@Resource
	private UsersService usersService;
	@Resource
	private BooksService bookService;
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 管理员管理用户，展示所有用户信息
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<Users> showUser(@RequestParam(required=false) int pageNow,@RequestParam(required=false) int pageSize){
		int totalCount=usersService.showAllCount();
		List<Users> userList=usersService.showUser(pageNow,pageSize);
		return userList;
	}
	
	/**
	 * 根据Id查询用户
	 * 
	 * @return
	 */
//	@RequestMapping(value="/user_show/{id}",method=RequestMethod.GET)
//	public String showUserById(Model model,@PathVariable Integer id) {
//		Users user = this.usersService.getUserById(id);
//		model.addAttribute("user", user);
//		return "userEdit";
//	}

	/**
	 * 根据id删除用户
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/delete/{userid}")
	public String deleteUser(@PathVariable Integer userid) {
		usersService.deleteUserById(userid);
		// 根据id删除某个用户后跳转到用户列表界面
		return "redirect:/user_list";
	}
	
	@RequestMapping(value = "/go_adminAdd")
	public String regist(Model model) {
		model.addAttribute("user", new Users());
		return "adminAddadmin";
	}
	
	/**
	 * 添加新的管理员
	 * @param user
	 * @param request
	 * @return
	 */
//	@RequestMapping(method = RequestMethod.POST)
//	public String save(@ModelAttribute Users user, HttpServletRequest request) {
//		
//		if (usersService.validateAdminUnique(user) == null) {
//			//设置等级为2，表示管理员
//			user.setUsergrade(2);
//			usersService.insertUser(user);
//			System.out.println("添加成功");
//			return "userMangage";
//		} else {
//			request.setAttribute("error", "该管理员已存在");
//			System.out.println("添加失败");
//			return "adminAddadmin";
//		}
//
//	}
	/**
	 * 跳转到管理导航页面
	 * @return
	 */
	@RequestMapping(value = "/go_navigation")
	public String goNavigation() {
		return "indexAdmin";
	}
	

}
