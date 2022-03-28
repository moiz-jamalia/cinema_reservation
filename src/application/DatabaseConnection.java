package application;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {

	static Connection connection = null;
	final static String jdbcURL = "jdbc:mysql://localhost:3307/cinema?allowPublicKeyRetrieval=true&useSSL=false";
//	final static String username = "cinema_admin";
	final static String username = "root";
//  final static String password = "cinema_reservation";
	final static String password = "root";

	static Connection DBConnection() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Successfully connected to database");
		} catch (Exception e) {
			System.out.println("Connection to the Database failed");
			e.printStackTrace();
		}
		return connection;
	}
}