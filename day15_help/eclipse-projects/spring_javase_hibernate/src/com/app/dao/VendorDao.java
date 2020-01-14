package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Vendor;

@Repository
public class VendorDao implements VendorDaoIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select distinct v from Vendor v join fetch v.card join fetch v.vehicles";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).getResultList();
	}

	@Override
	public Vendor getVendorDeatils(int id) {
		
		return sf.getCurrentSession().get(Vendor.class,id);
	}

	@Override
	public String deleteVendor(Vendor v) {
		
		sf.getCurrentSession().delete(v);
		return "Vendor with ID "+v.getId()+" deleted successfully";
	}

	@Override
	public String updateVendor(Vendor v) {
		sf.getCurrentSession().update(v);
		return "Vendor with ID "+v.getId()+" updated successfully";
	}

	@Override
	public String registerVendor(Vendor v) {
		System.out.println("vendor dao "+v);
		System.out.println(v.getCard());
		System.out.println(v.getVehicles());
		//rev asso values 
		System.out.println(v.getCard().getMyVendor());
		System.out.println(v.getVehicles().get(0).getMyVendor());

		Integer id=(Integer)sf.getCurrentSession().save(v);
		return "Vendor registered Successfully with ID "+id;
	}
	

}
