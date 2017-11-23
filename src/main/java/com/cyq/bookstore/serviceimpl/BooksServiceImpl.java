package com.cyq.bookstore.serviceimpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyq.bookstore.dao.BooksDao;
import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.service.BooksService;
@Service("booksService")
public class BooksServiceImpl implements BooksService{

	@Autowired
	private BooksDao booksDao;
	
	@Override
	public int insert(Books record) {
		return booksDao.insertSelective(record);
	}
	
	@Override
	public int deleteBooks(Integer bookid){
		return booksDao.deleteByPrimaryKey(bookid);
	}
	
	@Override
	public Books selectBookById(Integer bookid) {

		Books book=null;
		if(booksDao.selectByPrimaryKey(bookid).size()>0){
			book=booksDao.selectByPrimaryKey(bookid).get(0);
		}
		
		return book;
	}
	
	@Override
	public int updateBooks(Books book) {
		return booksDao.updateByPrimaryKey(book);
	}
	
	@Override
	public List<Books> selectAllBook() {
		return booksDao.selectAllBook();
	}
	
	@Override
	public List<Books> selectBookByCategoryId(Integer CategoryId){
		return booksDao.selectBookByCategoryId(CategoryId);
	}
	
	@Override
	public List<Books> selectBookByCondition(Books book){
		return booksDao.selectBookByCondition(book);
	}
}
