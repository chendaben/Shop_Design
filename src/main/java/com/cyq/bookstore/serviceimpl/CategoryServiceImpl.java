package com.cyq.bookstore.serviceimpl;

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
		return categoryDao.selectAllCategory();
	}

	@Override
	public Category selectByPrimaryKey(Integer categoryid) {
		return categoryDao.selectByPrimaryKey(categoryid);
	}


}
