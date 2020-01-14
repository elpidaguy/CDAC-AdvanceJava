package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.pojos.UserRole;

@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
	// dependency
	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> listVendors() {
		String jpql = "select u from User u where u.role=:rl";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("rl", UserRole.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(int vendorId) {
		String mesg = "Vendor deletion failed....";
		Session hs = sf.getCurrentSession();
		// get vendor detail from id
		User u = hs.get(User.class, vendorId);
		if (u != null) {
			hs.delete(u);
			mesg = "Vendor with ID : " + vendorId + " deletion succeeded";
		}
		return mesg;
	}

	@Override
	public User getCompleteDetails(int vid) {
		String jpql = "select u from User u left outer join fetch u.accounts where u.id=:id";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("id", vid).getSingleResult();
	}

	@Override
	public String registerVendor(User u) {
		sf.getCurrentSession().persist(u);
		return "Vendor with ID "+u.getId()+" registered successfully";
	}

	@Override
	public User getVendorDetails(int vid) {
		//get only vendor details
		return sf.getCurrentSession().get(User.class, vid);
	}

	@Override
	public String updateVendor(User u) {
		sf.getCurrentSession().update(u);
		return "Vendor with ID "+u.getId()+" updated";
	}
	
	
	

}
