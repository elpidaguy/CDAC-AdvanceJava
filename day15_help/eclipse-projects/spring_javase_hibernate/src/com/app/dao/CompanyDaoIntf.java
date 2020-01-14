package com.app.dao;

import java.util.List;

import pojos.Company;

public interface CompanyDaoIntf {
	public String addVendorToCompany(int vendorId,int compId);
	public String removeVendorFromCompany(int vendorId,int compId);
	public List<Company> listCompanies(int vendorId);
	public List<Company> allCompanies();
	

}
