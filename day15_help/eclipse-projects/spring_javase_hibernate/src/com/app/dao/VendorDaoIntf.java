package com.app.dao;
import java.util.List;
import pojos.Vendor;

public interface VendorDaoIntf {
	List<Vendor> listVendors();
	Vendor getVendorDeatils(int id);
	String deleteVendor(Vendor v);
	String updateVendor(Vendor v);
	String registerVendor(Vendor v);
}
