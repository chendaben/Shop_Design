package com.cyq.bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyq.bookstore.dao.CategoryDao;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.service.CategoryService;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource
	private CategoryDao categoryDao;

	@Override
	public List<Category> selectAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.selectAllCategory();
	}

	@Override
	public Category selectByPrimaryKey(Integer categoryid) {
		// TODO Auto-generated method stub
		return categoryDao.selectByPrimaryKey(categoryid);
	}


}
