package dao;

import pojos.Customer;

public interface ICustomerDao {
	public Customer signIn(String email,String pass) throws Exception;

	public boolean signUp(Customer c) throws Exception;
}
