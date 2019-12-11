package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	// add a static method to ret DB conn
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		if (cn == null) {
			String url = "jdbc:mysql://localhost:3306/test_acts";
			// mandatory in Java EE
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, "root", "");
		}
		return cn;
	}
}
