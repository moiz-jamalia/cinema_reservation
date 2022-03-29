package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.QueryResult;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RegistrationController {
	
	@FXML
	private StackPane stackPane;
	
	@FXML
	private AnchorPane mainloginPane;
	
	@FXML 
	private JFXTextField userName;
	
	@FXML
	private JFXTextField lastName;
	
	@FXML
	private JFXTextField firstName;
	
	@FXML 
	private JFXPasswordField pwfield;
	
	@FXML
	private JFXPasswordField confirmpwfield;
	
	@FXML
	private JFXButton registerbtn;
	
	@FXML
	private JFXButton cancelbtn;
	
	@FXML
	private Stage stage;
	
	@FXML
	public void cancelButtonAction(ActionEvent event) {
		try {
			WindowNavigation.switchToView("Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void registrationButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		Connection conDB = DatabaseConnection.DBConnection();
		
		if (pwfield.getText() == confirmpwfield.getText()) {
			if (!(userName.getText().equals(DatabaseConnection.getUserName(userName.getText())))) {
				String insert = "INSERT INTO user_account"
						+ " (firstname, lastname, username, password, user_role) "
						+ "VALUES (' " + userName.getText() + "', '" + lastName.getText() + "', '" + userName.getText() + "', '" + pwfield.getText() + "';";
				
				Statement stmt = conDB.createStatement();
				ResultSet queryRes = stmt.executeQuery(insert);
			}else {
				
				WindowNavigation.infoWindow(stage, registerbtn, LoginController, "a");
			}
		}
	}
}