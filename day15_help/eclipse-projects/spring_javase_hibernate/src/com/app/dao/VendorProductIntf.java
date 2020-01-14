package com.app.dao;

import java.util.List;

import pojos1.*;

public interface VendorProductIntf {
	String addVendor(Vendor v);
	String addProduct(Product p);
	String addVendorProduct(long vid,long pid,double price);
	List<VendorProduct> getProductDetailsByVendor(long vid);
}
