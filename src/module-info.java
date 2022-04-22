module cinema_reservation {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires com.jfoenix;
	requires java.sql;
	requires mysql.connector.java;
	requires charm.glisten;
	
	opens application to javafx.graphics, javafx.fxml;
}