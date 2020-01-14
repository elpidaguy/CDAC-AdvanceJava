package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.utils.CustomDateDeserializer;
import com.app.utils.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="stocks")
public class Stock {
	private Integer id;
	private String name,company;
	@Range(min=100,max=500)
	private int quantity;
	private double price;
	@DateTimeFormat(pattern="yyyy-MM-dd") //conversion
	//@JsonFormat(pattern="yyyy-MM-dd") //marshalling n un marshalling
	@JsonSerialize(using=CustomDateSerializer.class)
	@JsonDeserialize(using=CustomDateDeserializer.class)
	private Date publishDate;
	public Stock() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	public Stock(String name, String company, int quantity, double price, Date publishDate) {
		super();
		this.name = name;
		this.company = company;
		this.quantity = quantity;
		this.price = price;
		this.publishDate = publishDate;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20,unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", company=" + company + ", quantity=" + quantity + ", price="
				+ price + ", publishDate=" + publishDate + "]";
	}
	
	

}
