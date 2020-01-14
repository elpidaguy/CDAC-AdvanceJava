package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VendorDaoIntf;

import pojos.Vendor;

@Service
@Transactional
public class VendorService implements VendorServiceIntf {
	@Autowired
	private VendorDaoIntf dao;

	@Override
	public List<Vendor> listVendors() {

		return dao.listVendors();
	}

	@Override
	public String deleteVendor(int id) {
		// get vendor details by id
		Vendor v = dao.getVendorDeatils(id);
		return dao.deleteVendor(v);
	}

	@Override
	public Vendor getVendorDetails(int id) {
		Vendor v=dao.getVendorDeatils(id);
		//for showing Vendor & its vehicle details (one --many ) 
		//w/o Lazy Init exc
		v.getVehicles().size();
		return v;
	}

	@Override
	public String updateVendor(Vendor v) {

		return dao.updateVendor(v);
	}

	@Override
	public String registerVendor(Vendor v) {
		// MUST establish reverse association from Card ---> Vendor
		// o.w cards table's FK column null
		v.getCard().setMyVendor(v);
		// MUST establish reverse association from Vehicle ---> Vendor
		// o.w vehicle table's FK column null
		v.getVehicles().forEach(vcl -> vcl.setMyVendor(v));
		return dao.registerVendor(v);
	}

}
