package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

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
		int username = DatabaseConnection.getUserName(userName.getText());
		
		String password = pwfield.getText();
		String confirmpassword = confirmpwfield.getText();
		
		System.out.println("Password: " + password);
		System.out.println("Confirmpassword: " + confirmpassword);
		
		if (firstName.getText().isBlank() || lastName.getText().isBlank() || userName.getText().isBlank() || pwfield.getText().isBlank() || confirmpwfield.getText().isBlank()) {
			if (password.equals(confirmpassword)) {
				if (username == 0) {
					String insert = "INSERT INTO user_account"
							+ " (firstname, lastname, username, password, user_role) "
							+ "VALUES ('" + firstName.getText() + "', '" + lastName.getText() + "', '" + userName.getText() + "', '" + pwfield.getText() + "', 'user');";
					try {
						Statement stmt = conDB.createStatement();
						stmt.executeUpdate(insert);
						System.out.println("Data inserted successfully");
						WindowNavigation.switchToView("Login");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("inserting Data unsuccessful");
					}
					
				}else System.out.println("Username already Taken"); //WindowNavigation.infoWindow(stage, registerbtn, "Username is already Taken!");
				
			}else System.out.println("the password is not equal with the input"); //WindowNavigation.infoWindow(stage, registerbtn, "the password are not equal with the input");
		}else System.out.println("please complete your registration!");
	}
}