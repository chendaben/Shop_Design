package com.cyq.bookstore.pojo;

import java.util.List;

public class Category {
	private Integer categoryid;
	private String categoryname;
	private List<Books> books;
	public Category(){
		
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
	
	
}
