package com.cyq.bookstore.service;

import java.util.List;

import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.pojo.Users;

public interface UsersService {
	/**
	 * 展示所有用户信息
	 */
	public List<Users> showUser(int pageNow,int pageSize);
	/**
	 * 根据id得到用户
	 */
	public Users getUserById(int userId);
	/**
	 * 根据id删除用户
	 */
	public int deleteUserById(int userId);
	/**
	 * 添加用户信息
	 */
	public int insertUser(String username,String userpassword,String userphone,String useremail);
	/**
	 * 更新用户信息
	 */
	public int updateUser(Users user);
	/**
	 * 登录验证
	 */
	public Users selectUsers(Users user);
	 
	/**
	  * 把商品加入购物车
	  */
	public int insetShopBook(ShopBook shopBook);
	/**
	 * 展示购物车
	 */
	public List<ShopBook> showShopBook(int userId);
	/**
	 * 展示用户总数目
	 */
	public int showAllCount();
	
	/**
	 * 
	 */
	public ShopBook getShopCartByCondition(ShopBook shopBook);
	
	
	public int updateByShopId(ShopBook shopBook);
	
	/**
	 *验证管理员的唯一性
	 */
	public Users validateAdminUnique(Users user);
}
