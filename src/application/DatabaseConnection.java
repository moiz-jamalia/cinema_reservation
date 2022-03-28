package application;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DatabaseConnection {

	static Connection connection = null;
	final static String jdbcURL = "jdbc:mysql://localhost:3307/cinema?allowPublicKeyRetrieval=true&useSSL=false";
	final static String username = "root";
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

	static int getUserName(String username, Connection connection) throws SQLException {

		String getUserName = "SELECT COUNT(1) FROM user_account WHERE username = '" + username + "';";
		int userName = 0;

		Statement stmt = connection.createStatement();
		ResultSet queryRes = stmt.executeQuery(getUserName);

		while (queryRes.next()) {
			
			if (queryRes.getInt(1) == 1) userName = 1;
		}
		return userName;
	}

	static int getPassword(String pw, Connection connection) throws SQLException {

		String getPassword = "SELECT COUNT(1) FROM user_account WHERE password = '" + pw + "';";
		int password = 0;

		Statement stmt = connection.createStatement();
		ResultSet queryRes = stmt.executeQuery(getPassword);

		while (queryRes.next()) {

			if(queryRes.getInt(1) == 1) password = 1;
			
		}
		return password;
	}
}