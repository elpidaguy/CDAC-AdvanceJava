package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class AccountPK implements Serializable {
	private int acctId;
	private int branchId;
	public AccountPK() {
		System.out.println("in acct key constr");
	}
	public AccountPK(int acctId, int branchId) {
		super();
		this.acctId = acctId;
		this.branchId = branchId;
	}
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	@Override
	public String toString() {
		return "AccountPK [acctId=" + acctId + ", branchId=" + branchId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctId;
		result = prime * result + branchId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPK other = (AccountPK) obj;
		if (acctId != other.acctId)
			return false;
		if (branchId != other.branchId)
			return false;
		return true;
	}
	
	
	
	

}
