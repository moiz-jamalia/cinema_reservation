package application;

import java.io.IOException;
import java.sql.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
	private ImageView imageView;

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
	public void loginButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		if (!userName.getText().isBlank() && !pwfield.getText().isBlank()) InfoWindow(); 
	}

	public void validateLogin() throws ClassNotFoundException, SQLException {
		Connection conDB = DatabaseConnection.DBConnection();
		
		String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + userName.getText() + "' AND password = '" + pwfield.getText() + "';";

		try {
			Statement stmt = conDB.createStatement();
			ResultSet queryRes = stmt.executeQuery(verifyLogin);

			while (queryRes.next()) {
				if (queryRes.getInt(1) == 1) WindowNavigation.switchToView("WelcomeScreen");
				else InfoWindow();
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	@FXML
	private void InfoWindow() throws IOException, SQLException, ClassNotFoundException {
		
		int username = DatabaseConnection.getUserName(userName.getText());
		int pw = DatabaseConnection.getPassword(pwfield.getText());
				
		if (username == 1 && pw == 0) {
//			infoLabel.setText("Password is incorrect");
			PopUpScreenController.infoWindow(loginbtn, "Password is incorrect");
		}else if (username == 0 && pw == 1) {
//			infoLabel.setText("username is incorrect");
			PopUpScreenController.infoWindow( loginbtn, "Username is incorrect");
		}else if (username == 0 && pw == 0) {
//			infoLabel.setText("username & Password are incorrect");
			PopUpScreenController.infoWindow(loginbtn, "Username & Password are incorrect");
		}else validateLogin();
	}
}