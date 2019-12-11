package dao;

import pojos.Customer;
import java.sql.*;
import static utils.DBUtils.*;

public class CustomerDaoImpl implements ICustomerDao {
	private Connection cn;
	private PreparedStatement pst1,pst2;

	// constr
	public CustomerDaoImpl() throws Exception {
		// cn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		pst2 = cn.prepareStatement("insert into my_customers values(default,?,?,?,?");
		System.out.println("customer dao created");
	}
	
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("cust dao cleaned up");
		
	}

	@Override
	public Customer signIn(String email, String pass) throws Exception {
		//set IN params
		pst1.setString(1, email);
		pst1.setString(2, pass);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				return new Customer(rst.getInt(1), email, pass, rst.getDouble(4), rst.getDate(5));
		}
		return null;
	}

	@Override
	public boolean signUp(Customer c) throws Exception {
		pst2.setString(1,c.getEmail());
		pst2.setString(2,c.getPass());
		pst2.setDouble(3,c.getAmount());
		pst2.setDate(4, c.getRegDate());
		
		int res = pst2.executeUpdate();
		
		if(res > 0)
		{
			return true;
		}
		
		return false;
	}

}
