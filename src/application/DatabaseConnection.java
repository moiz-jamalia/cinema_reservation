package application;

import java.sql.DriverManager;
import java.sql.Connection;


public class DatabaseConnection {
	static Connection connection = null;

	
	static Connection DBConnection() {
		String URL = "jdbc:mysql://localhost:3307";
		String user = "root";
		String pw = "Moiz&2oo2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, user, pw);
			System.out.println("Successfully connected to database");
		} catch (Exception e) {
			System.out.println("Connection to the Database failed");
			e.printStackTrace();
			e.getCause();
		}
		 return connection;
	}
}