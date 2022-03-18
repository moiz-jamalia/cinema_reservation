module cinema_reservation {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires com.jfoenix;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}