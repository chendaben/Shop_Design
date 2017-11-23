package com.cyq.bookstore.service;

import java.util.List;

import com.cyq.bookstore.pojo.Books;

public interface BooksService {
	/**
     * 插入书籍
     */
	public int insert(Books record);
	/**
	 * 根据id删除书籍
	 */
	public int deleteBooks(Integer bookid);
	/**
	 * 根据id查找书籍
	 */
	public Books selectBookById(Integer bookid);
	/**
	 * 更新书籍信息
	 */
	public int updateBooks(Books book);
	/**
	 * 查出所有书籍
	 */
	public List<Books> selectAllBook();
	/**
	 * 根据类别查询该类别下的书籍
	 */
	public List<Books> selectBookByCategoryId(Integer CategoryId);
	
	/**
	 * 根据条件查找数据（可添加条件）
	 */
	public List<Books> selectBookByCondition(Books book);
}
