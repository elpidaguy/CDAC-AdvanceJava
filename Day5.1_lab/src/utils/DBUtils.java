package utils;

import java.sql.*;

public class DBUtils {

	private static Connection cn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(cn == null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_dac","root","");
			return cn;
		}
		
		return cn;
		
	}
}
