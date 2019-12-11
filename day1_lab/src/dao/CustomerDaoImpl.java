package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import pojos.Customer;

public class CustomerDaoImpl implements ICustomerDao{
	
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	

	public CustomerDaoImpl() throws ClassNotFoundException, SQLException {
		cn = fetchConnection();
		
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		pst2 = cn.prepareStatement("insert into my_customers values(default,?,?,?,?)");
		pst3 = cn.prepareStatement("select * from my_customers");
	}

	@Override
	public HashMap<Integer, Customer> getCustomers() throws Exception {
		HashMap<Integer,Customer> customerMap = new HashMap<>();
		
		try(ResultSet rst = pst3.executeQuery())
		{
			while(rst.next())
				customerMap.put(rst.getInt(1),new Customer(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDate(5)));
		}
		
		return customerMap;
	}

	@Override
	public Customer signIn(String email, String pass) throws Exception {
		
		Customer cust = null;
		pst1.setString(1,email);
		pst1.setString(2, pass);
		
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				cust = new Customer(rst.getInt(1),rst.getString(2),rst.getDouble(4),Date.valueOf(rst.getString(5)));
		}
		
		return cust;
	}

	@Override
	public String signUp(Customer c) throws Exception {
		pst2.setString(1, c.getEmail());
		pst2.setString(2, c.getPassword());
		pst2.setDouble(3, c.getReg_amt());
		pst2.setDate(4, c.getReg_date());
		
		int affectedRows = pst2.executeUpdate();
		if(affectedRows == 1)
		{
			return "Customer Registered Successfully";
		}
		else
		{
			return "Something went Wrong";
		}
	}
	
	

}
