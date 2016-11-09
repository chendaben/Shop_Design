package com.cyq.bookstore.pojo;
/**
 * 书籍类
 */
import java.io.Serializable;
/**
 * Books实体类
 */
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Books implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4817168264227524467L;

	// 上传文件属性
	private List<MultipartFile> images;

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	private Integer bookid;

	private String bookname;

	private String bookauthor;

	private String bookpress;

	private BigDecimal bookprice;

	private Integer booktotalnum;

	private Integer bookremainnum;
	
	private Integer categoryId;
	
	private String imageUrl;
	
	private Category category;
     
	private ShopBook shopbook;
	
	

	public ShopBook getShopbook() {
		return shopbook;
	}

	public void setShopbook(ShopBook shopbook) {
		this.shopbook = shopbook;
	}
		
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Books() {

	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname == null ? null : bookname.trim();
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor == null ? null : bookauthor.trim();
	}

	public String getBookpress() {
		return bookpress;
	}

	public void setBookpress(String bookpress) {
		this.bookpress = bookpress == null ? null : bookpress.trim();
	}

	public BigDecimal getBookprice() {
		return bookprice;
	}

	public void setBookprice(BigDecimal bookprice) {
		this.bookprice = bookprice;
	}

	public Integer getBooktotalnum() {
		return booktotalnum;
	}

	public void setBooktotalnum(Integer booktotalnum) {
		this.booktotalnum = booktotalnum;
	}

	public Integer getBookremainnum() {
		return bookremainnum;
	}

	public void setBookremainnum(Integer bookremainnum) {
		this.bookremainnum = bookremainnum;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
