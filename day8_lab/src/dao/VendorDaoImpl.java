package dao;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {

		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Integer id = (Integer) hs.save(v);
			System.out.println(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return "Vendor Registered Successfully with ID: " + v.getId();
	}

	@Override
	public Vendor getDetails(int id) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Vendor v = null;
		try {
			v = hs.get(Vendor.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return v;
	}

	@Override
	public List<Vendor> getAllVendors() {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Vendor> vendorList = null;
		String jpql = "select v from Vendor v";
		try {
			vendorList = hs.createQuery(jpql,Vendor.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return vendorList;
	}

	@Override
	public List<Vendor> getSelectedVendors(String city, LocalDate dt) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Vendor> vendorList = null;
		String jpql = "select v from Vendor v where v.city= :ct and v.regDate > :rd";
		try {
			vendorList = hs.createQuery(jpql,Vendor.class).setParameter("ct", city).setParameter("rd", dt).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return vendorList;
	}

	@Override
	public String updateVendorDetails(int vid, String newCity, String newPhone) {
		String jpql = "select v from Vendor v where v.id = :vid";
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Vendor v = hs.createQuery(jpql, Vendor.class).setParameter("vid", vid).getSingleResult();
			//user validated
			v.setCity(newCity);
			v.setPhone(newPhone);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Vendor's details updated...";
	}

	@Override
	public String deleteVendorDetails(int vid) {
		String jpql = "select v from Vendor v where v.id = :vid";
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Vendor v = hs.createQuery(jpql, Vendor.class).setParameter("vid", vid).getSingleResult();
			hs.delete(v);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Vendor Deleted";
	}

}
