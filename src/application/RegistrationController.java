package application;

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
	public void cancelButtonAction(ActionEvent event) {
		try {
			WindowNavigation.switchToView("Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}