package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public interface IVendorDao {

	String registerVendor(Vendor v);
	Vendor getDetails(int id);
	List<Vendor> getAllVendors();
	List<Vendor> getSelectedVendors(String city,LocalDate dt);
	String updateVendorDetails(int vid,String newCity,String newPhone);
	String deleteVendorDetails(int vid);
	
}
