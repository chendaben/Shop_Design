package com.cyq.bookstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cyq.bookstore.pojo.Books;
import com.cyq.bookstore.pojo.Category;
import com.cyq.bookstore.service.BooksService;
import com.cyq.bookstore.service.CategoryService;
import com.cyq.bookstore.util.Pager;

@Controller
public class BooksController {
	
	@Resource
	private BooksService booksService;
	
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 根据id跳转到书籍详情页面
	 */
	@RequestMapping(value="/book_detail")
	public String detailBook(@RequestParam Integer bookid,Model model){
		Books book=booksService.selectBookById(bookid);
		model.addAttribute("book", book);
		return "bookDetail";
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String listBook(Model model,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
			@RequestParam(value = "name", required = false, defaultValue = "")String name){
		//根据书籍名称搜索
		List<Books> list=new ArrayList<Books>();
		if(StringUtils.isNotBlank(name)){
			Books book=new Books();
			for (Books b : booksService.selectAllBook()) {
				if (b.getBookname().toUpperCase().indexOf(name.toUpperCase()) != -1) {
					list.add(b);
				}
			}
		}else{
			list=booksService.selectAllBook();
		}
		//带入书籍类别信息
		List<Category> categorylist=categoryService.selectAllCategory();
		model.addAttribute("categoryList", categorylist);
		Pager<Books> pager = new Pager<Books>(pageNo,pageSize,list);
		int pageSum=(list.size() +pageSize -1)/pageSize;
		model.addAttribute("pageSum",pageSum);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("bookList",pager.getPagerObject());
		model.addAttribute("allList", list.size());
		return "index";
	}
	
	/**
	 * 根据书籍分类查询该类别下的书籍(待补充)
	 */
	@RequestMapping(value = "/book_category")
	public ModelAndView selectBookByCategoryId(Integer categoryid) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Books> list=new ArrayList<Books>();
		if(categoryid==null){
			list=booksService.selectAllBook();
		}else{
			list = booksService.selectBookByCategoryId(categoryid);
		}
		model.put("bookList", list);
		// 带入书籍类别信息
		List<Category> categorylist = categoryService.selectAllCategory();
		model.put("categoryList", categorylist);
		return new ModelAndView("index", model);
	}
	
	
}
