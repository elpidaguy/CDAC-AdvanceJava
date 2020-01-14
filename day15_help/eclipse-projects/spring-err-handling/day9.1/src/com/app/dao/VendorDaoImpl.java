package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;

@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Vendor getCompleteDetails(int id) {
		Vendor v=sf.getCurrentSession().get(Vendor.class,id);
		v.getAccts().size();
		v.getCards().size();
		return v;
	}

}
