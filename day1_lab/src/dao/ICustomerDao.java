package dao;

import java.util.HashMap;

import pojos.Customer;

public interface ICustomerDao {

	public HashMap<Integer,Customer> getCustomers() throws Exception;
	
	public Customer signIn(String email,String pass) throws Exception;

	public String signUp(Customer c) throws Exception;
	
}
