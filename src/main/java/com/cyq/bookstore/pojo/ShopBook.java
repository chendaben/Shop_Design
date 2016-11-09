package com.cyq.bookstore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 临时购物车表
 * 
 * @author Chendaben
 *
 */
@SuppressWarnings("serial")
public class ShopBook implements Serializable{
	private int shopid;
	private int userid;
	private int bookid;
	private int ordermount;
	private BigDecimal price;
	private String ispay;
	private List<Books> books;
	
	public ShopBook(){
		
	}
	public ShopBook(Integer userid, Integer bookid) {
		// TODO Auto-generated constructor stub
		this.userid=userid;
		this.bookid=bookid;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public int getOrdermount() {
		return ordermount;
	}

	public void setOrdermount(int ordermount) {
		this.ordermount = ordermount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIspay() {
		return ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	

}
