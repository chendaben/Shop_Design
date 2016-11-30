package com.cyq.bookstore.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyq.bookstore.dao.UsersDao;
import com.cyq.bookstore.pojo.Users;
import com.cyq.bookstore.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService{
	
	@Resource
	private UsersDao usersDao;

	@Override
	public Users getUserById(int userId) {
		
		return usersDao.selectByPrimaryKey(userId);
	}

	@Override
	public int deleteUserById(int userId) {
		
		return usersDao.deleteByPrimaryKey(userId);
	}
	
	@Override
	public int insertUser(String username,String userpassword,String userphone,String useremail) {
		Users user=new Users();
		user.setUsername(username);
		user.setUserpassword(userpassword);
		user.setUserphone(userphone);
		user.setUseremail(useremail);
		return usersDao.insertSelective(user);
	}

	@Override
	public int updateUser(Users user) {
		
		return usersDao.updateByPrimaryKey(user);
	}

	@Override
	public Users selectUsers(Users user) {
		
		return usersDao.selectUsers(user);
	}


	@Override
	public List<Users> showUser(int pageNow,int pageSize) {
		
		return usersDao.showUser(pageNow,pageSize);
	}

	@Override
	public int showAllCount() {
		
		return usersDao.showAllCount();
	}
	
	@Override
	public Users validateAdminUnique(Users user) {
		
		return usersDao.validateAdminUnique(user);
	}

}
