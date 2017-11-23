package com.cyq.bookstore.dao;

import java.util.List;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import org.springframework.stereotype.Repository;

public interface CategoryDao {
	
	/**
	 * 根据id获取类别
	 */
	Category selectByPrimaryKey(Integer categoryid);
	
	/**
	 * 查询所有分类
	 */
	List<Category> selectAllCategory();
	
	
	List<Books> selectBooksByCategory();
}
