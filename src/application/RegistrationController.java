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

public class RegistrationController {

	@FXML
	private StackPane stackPane;

	@FXML
	private AnchorPane mainRegistrationPane;

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

		if (!firstName.getText().isBlank() && !lastName.getText().isBlank() && !userName.getText().isBlank() && !pwfield.getText().isBlank() && !confirmpwfield.getText().isBlank()) {
			if (pwfield.getText().equals(confirmpwfield.getText())) {
				if (username == 0) {
					String insert = "INSERT INTO user_account (firstname, lastname, username, password, user_role) VALUES ('" + firstName.getText() + "', '" + lastName.getText() + "', '" + userName.getText() + "', '" + pwfield.getText() + "', 'user');";
					try {
						Statement stmt = conDB.createStatement();
						stmt.executeUpdate(insert);
						System.out.println("Data inserted successfully");
						WindowNavigation.switchToView("Login");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("inserting Data unsuccessful");
					}
				} else PopUpScreen.infoWindow("Username is already Taken!", "Please take another Username that isn't taken");
			} else PopUpScreen.infoWindow("the passwords are not indentical!", "Please enter the passwords again");
		}else PopUpScreen.infoWindow("please complete your Registration!", null);
	}
}