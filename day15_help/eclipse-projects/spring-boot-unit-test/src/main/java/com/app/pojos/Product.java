package com.app.pojos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {
	private String name;
	private double price;
	private Date expDate;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, double price, Date expDate) {
		super();
		this.name = name;
		this.price = price;
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	

}
