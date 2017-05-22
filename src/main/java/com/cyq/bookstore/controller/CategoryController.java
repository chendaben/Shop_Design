package com.cyq.bookstore.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.bookstore.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Resource
	private CategoryService categoryService; 
}
