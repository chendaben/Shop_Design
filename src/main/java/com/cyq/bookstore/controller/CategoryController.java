package com.cyq.bookstore.controller;

import javax.annotation.Resource;

import com.wordnik.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.bookstore.service.CategoryService;
@Api(value = "书籍分类")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Resource
	private CategoryService categoryService; 
}
