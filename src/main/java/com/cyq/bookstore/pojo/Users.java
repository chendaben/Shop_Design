package com.cyq.bookstore.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Chendaben Users实体类 用户实体类
 */
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6992065893562853318L;

	private Integer userid;

	private String username;

	private String userphone;

	private String useremail;

	private String userpassword;

	private Integer usergrade;
	
	private Integer userisuse;
	
	public Users() {

	}
	
	public Integer getUserisuse() {
		return userisuse;
	}

	public void setUserisuse(Integer userisuse) {
		this.userisuse = userisuse;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone == null ? null : userphone.trim();
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail == null ? null : useremail.trim();
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword == null ? null : userpassword.trim();
	}

	public Integer getUsergrade() {
		return usergrade;
	}

	public void setUsergrade(Integer usergrade) {
		this.usergrade = usergrade;
	}

	
	
	
}