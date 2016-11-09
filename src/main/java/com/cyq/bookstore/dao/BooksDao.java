package com.cyq.bookstore.dao;
import java.util.List;

import com.cyq.bookstore.pojo.Books;

public interface BooksDao {
	
    int deleteByPrimaryKey(Integer bookid);
   
    int insert(Books record);
    
    int insertSelective(Books record);

    List<Books> selectByPrimaryKey(Integer bookid);
    
    List<Books> selectAllBook();
    
    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    
    /**
     * 根据类别查询该类别下的书籍
     */
    List<Books> selectBookByCategoryId(Integer categoryId);
    
    List<Books> selectBookByCondition(Books book);
}
