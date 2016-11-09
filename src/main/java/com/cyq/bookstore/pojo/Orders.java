package com.cyq.bookstore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单表
 * @author Chendaben
 *
 */
@SuppressWarnings("serial")
public class Orders implements Serializable{
	private Integer orderid;
	private BigDecimal cost;
	private String paytype;
	private Date paytime;
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Orders(){
		
	}
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

}
