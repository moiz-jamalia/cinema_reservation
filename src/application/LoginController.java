package application;

import java.io.IOException;
//import java.sql.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private JFXTextField userName;
	
	@FXML
	private JFXPasswordField pwfield;

	@FXML
	private AnchorPane mainLoginPane;

	@FXML
	private StackPane stackPane;

	@FXML
	private JFXButton loginbtn;

	@FXML
	private JFXButton closebtn;

	@FXML
	private JFXButton registrationbtn;

	@FXML
	public void closeButtonAction(ActionEvent event) {
		Stage stage = (Stage) closebtn.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void registrationButtonAction(ActionEvent event) {
		try {
			WindowNavigation.switchToView("Registration");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loginButtonAction(ActionEvent event) throws IOException {
//		if (userName.getText().isBlank() == false && pwfield.getText().isBlank() == false) {
//			validateLogin();
//		}
		WindowNavigation.switchToView("Home");
	}

//	public void validateLogin() {
//		Connection conDB = DatabaseConnection.Connection();
//
//		String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + userName.getText() + "' AND password = '" + pwfield.getText() + "'";
//	
//		try {
//			Statement stmt = conDB.createStatement();
//			ResultSet queryRes = stmt.executeQuery(verifyLogin);
//			
//			while (queryRes.next()) {
//				if (queryRes.getInt(1) == 1) {
//					WindowNavigation.switchToView("Home");
//				}
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getCause();
//		}
//	}
}
