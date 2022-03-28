package application;

import java.io.IOException;
import java.sql.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

	@FXML
	private JFXTextField userName;

	@FXML
	private JFXPasswordField pwfield;

	@FXML
	private AnchorPane mainLoginPane;
	
	@FXML
	private AnchorPane mainPopUpPane;

	@FXML
	private StackPane stackPane;

	@FXML
	private JFXButton loginbtn;

	@FXML
	private JFXButton closebtn;

	@FXML
	private JFXButton registrationbtn;
	
	@FXML
	private JFXButton okaybtn;
	
	@FXML
	private Label infoLabel;
	
	@FXML
	private Stage stage;

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
				if (queryRes.getInt(1) == 1) WindowNavigation.switchToView("Home");
				else InfoWindow();
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	private void InfoWindow() throws IOException, SQLException, ClassNotFoundException {
		Connection conDB = DatabaseConnection.DBConnection();
		
		int username = DatabaseConnection.getUserName(userName.getText(), conDB);
		int pw = DatabaseConnection.getPassword(pwfield.getText(), conDB);
		
		System.out.println(infoLabel.getText());
				
		if (username == 1 && pw == 0) {
			infoLabel.setText("Password is incorrect");
			WindowNavigation.infoWindow(stage, loginbtn);
		}else if (username == 0 && pw == 1) {
			infoLabel.setText("username is incorrect");
			WindowNavigation.infoWindow(stage, loginbtn);
		}else if (username == 0 && pw == 0) {
			infoLabel.setText("username & Password are incorrect");
			WindowNavigation.infoWindow(stage, loginbtn);
		}else validateLogin();
		
	}
	
	@FXML
	public void okayButtonAction(ActionEvent event) {
		if (event.getTarget() == okaybtn) stage.close();
		else stage.showAndWait();
	}
}