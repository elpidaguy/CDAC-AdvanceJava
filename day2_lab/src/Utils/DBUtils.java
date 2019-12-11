package Utils;

import java.sql.*;

public class DBUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3333/test_dac","root","actscdac");
	}
}
