package application;

import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseConnection {
	
	static Connection conn = null;

	static Connection DBConnection() throws ClassNotFoundException {
		final String URL = "jdbc:mysql://127.0.0.1:3307/cinema";
		final String user = "cinema_admin@localhost";
		final String pw = "cinema_reservation";
		try {
			DatabaseConnection.class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, pw);
			System.out.println("Successfully connected to database");
		} catch (Exception e) {
			System.out.println("Connection to the Database failed");
			System.out.println(e);
			e.getCause();
		}
		return conn;
	}
}