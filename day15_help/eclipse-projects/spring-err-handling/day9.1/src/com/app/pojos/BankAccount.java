package com.app.pojos;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="bank_accts")
public class BankAccount {
	private Integer acctNo;
	private AccType acType;
	private double balance;
	//many to one 
	@JsonBackReference
	private Vendor myVendor;
	public BankAccount() {
		System.out.println("in acct constr");
	}
	public BankAccount(AccType acType, double balance) {
		super();
		this.acType = acType;
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acct_no")
	public Integer getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ac_type",length=20)
	public AccType getAcType() {
		return acType;
	}
	public void setAcType(AccType acType) {
		this.acType = acType;
	}
	@Column(columnDefinition="double(8,1)")
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@ManyToOne //owning  side --FK col
	@JoinColumn(name="v_id")
	public Vendor getMyVendor() {
		return myVendor;
	}
	public void setMyVendor(Vendor myVendor) {
		this.myVendor = myVendor;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", acType=" + acType + ", balance=" + balance + "]";
	}
	

}
