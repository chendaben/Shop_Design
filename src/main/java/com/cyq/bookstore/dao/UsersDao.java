package com.cyq.bookstore.dao;

import java.util.List;

import com.cyq.bookstore.pojo.Users;
import org.springframework.stereotype.Repository;

public interface UsersDao {
	
	/**根据id删除用户 */
    int deleteByPrimaryKey(Integer userid);
    
    /** 插入新用户*/
    int insert(Users record);
    
    /**插入新用户 */
    int insertSelective(Users record);
    
    /**根据id查找用户 */
    Users selectByPrimaryKey(Integer userid);
    
    /**查找用户 */
    Users selectUsers(Users user);
    
    /**验证管理员的唯一性*/
    Users validateAdminUnique(Users user);
    
    /**根据id更新用户信息 */
    int updateByPrimaryKeySelective(Users record);
    
    /** 根据id更新用户信息*/
    int updateByPrimaryKey(Users record);
    
    /**分页展示所有用户 */
    List<Users> showUser(int pageNow,int pageSize);
    
    /**显示user的总数目 */
    int showAllCount();
    
}