package com.cyq.bookstore.service;

import java.util.List;

import com.cyq.bookstore.pojo.Category;


public interface CategoryService {
	/**
	 * 列出所有书籍种类
	 * @return
	 */
	List<Category> selectAllCategory();
	/**
	 * 根据id查找种类
	 * @param categoryid
	 * @return
	 */
	Category selectByPrimaryKey(Integer categoryid);
}
