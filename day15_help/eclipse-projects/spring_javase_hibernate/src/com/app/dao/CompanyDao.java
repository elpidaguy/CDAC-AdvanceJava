package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.Company;
import pojos.Vendor;

@Repository
@Transactional
public class CompanyDao implements CompanyDaoIntf {

	@Autowired
	private SessionFactory sf;

	@Override
	public String addVendorToCompany(int vendorId, int compId) {
		String status = "Adding Vendor To Company Failed!";
		// validate vendor
		Vendor v = sf.getCurrentSession().get(Vendor.class, vendorId);
		Company c = sf.getCurrentSession().get(Company.class, compId);

		if (v != null && c != null) {
			c.addVendor(v);
			status = "Vendor added successfully to Company!";
		}
		return status;
	}

	@Override
	public String removeVendorFromCompany(int vendorId, int compId) {
		String status = "Removing Vendor To Company Failed!";
		// validate vendor
		Vendor v = sf.getCurrentSession().get(Vendor.class, vendorId);
		Company c = sf.getCurrentSession().get(Company.class, compId);

		if (v != null && c != null) {
			c.removeVendor(v);
			status = "Vendor removed successfully from Company!";
		}

		return status;

	}

	// list currently registered companies with current vendor
	@Override
	public List<Company> listCompanies(int vendorId) {
		List<Company> l1 = sf.getCurrentSession().get(Vendor.class, vendorId).getCompanies();
		l1.size();
		return l1;
	}

	// list all companies
	@Override
	public List<Company> allCompanies() {
		String jpql = "select c from Company c";
		return sf.getCurrentSession().createQuery(jpql, Company.class).getResultList();
	}

}
