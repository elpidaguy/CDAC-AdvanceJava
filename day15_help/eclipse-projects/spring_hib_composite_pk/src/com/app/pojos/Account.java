package com.app.pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="new_accts")
public class Account {
	
	private AccountPK id;
	private String name;
	private String type;
	private double bal;
	
	public Account() {
		System.out.println("in acct def constr");
	}
	public Account(String name, String type, double bal) {
		super();
		this.name = name;
		this.type = type;
		this.bal = bal;
	}
	@Id
	//or @EmbeddedId
	public AccountPK getId() {
		return id;
	}
	public void setId(AccountPK id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", type=" + type
				+ ", bal=" + bal + "]";
	}
	
	
	

}
