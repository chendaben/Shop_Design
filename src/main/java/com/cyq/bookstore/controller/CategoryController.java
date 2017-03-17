package com.cyq.bookstore.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyq.bookstore.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Resource
	private CategoryService categoryService; 
}
