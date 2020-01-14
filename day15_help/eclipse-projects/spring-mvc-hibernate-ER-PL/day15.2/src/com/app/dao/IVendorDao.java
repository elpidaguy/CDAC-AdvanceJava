package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IVendorDao {
	List<User> listVendors();
	String deleteVendorDetails(int vendorId);
	User getCompleteDetails(int vid);
	String registerVendor(User u);
	User getVendorDetails(int vid);//only vendor dtls --no a/c details
	String updateVendor(User u);
	
}
