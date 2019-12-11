package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection fetchConnection() throws SQLException,ClassNotFoundException
	{
		String url="jdbc:mysql://localhost:3333/test_dac";
		return DriverManager.getConnection(url,"root","actscdac");
		
	}

}
