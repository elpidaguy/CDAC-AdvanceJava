package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class BankAccount extends AbstractEntity {
	private AcType acType;
	private double balance;
	//many-to-one
	private User owner;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(AcType acType, double balance) {
		super();
		this.acType = acType;
		this.balance = balance;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ac_type",length=20)
	public AcType getAcType() {
		return acType;
	}
	public void setAcType(AcType acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "BankAccount ID :"+getId()+" acType=" + acType + ", balance=" + balance + "]";
	}
	

}
