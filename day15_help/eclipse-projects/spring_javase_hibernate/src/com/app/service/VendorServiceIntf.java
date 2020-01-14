package com.app.service;

import java.util.List;
import pojos.Vendor;

public interface VendorServiceIntf {
	List<Vendor> listVendors();
	String deleteVendor(int id);
	Vendor getVendorDetails(int id);
	String updateVendor(Vendor v);
	String registerVendor(Vendor v);
}
