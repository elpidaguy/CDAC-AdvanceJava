package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos1.*;

@Repository("vendor_dao")
@Transactional
public class VendorProductImpl implements VendorProductIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	public String addVendor(Vendor v) {
		sf.getCurrentSession().save(v);
		return "Vendor added with ID " + v.getId();
	}

	@Override
	public String addProduct(Product p) {
		sf.getCurrentSession().save(p);
		return "Product added with ID " + p.getId();
	}

	@Override
	public String addVendorProduct(long vid, long pid, double price) {
		Session hs = sf.getCurrentSession();
		Vendor v = hs.get(Vendor.class, vid);
		Product p = hs.get(Product.class, pid);
		if (v != null && p != null) {
			VendorProduct vp = new VendorProduct();
			v.addVendorProduct(vp);
			p.addVendorProduct(vp);
			vp.setPrice(price);
			hs.save(vp);
			return "Vendor product linked successfully";
		} else
			return "Vendor product linked failed";

	}

	@Override
	public List<VendorProduct> getProductDetailsByVendor(long vid) {
		String jpql = "select vp from VendorProduct vp where vp.vendor.id = :id";
		List<VendorProduct> l1 = sf.getCurrentSession().createQuery(jpql, VendorProduct.class).setParameter("id", vid)
				.getResultList();
		l1.forEach(vp -> System.out.println(vp.getPrice() + " -- " + vp.getProduct() + " " + vp.getVendor()));
		return l1;
	}

}
