package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopUpScreen {
	
	@FXML
	private JFXButton okaybtn;
	
	@FXML
	public static Label infoLabel;
	
	@FXML
	public static Stage stage;
	
	@FXML
	private StackPane stackPane;
	
	@FXML
	private AnchorPane mainPopUpPane;
	
	@FXML
	public void okayButtonAction(ActionEvent event) {
		Stage stage = (Stage) okaybtn.getScene().getWindow();
		stage.close();
	}
	
	public static void infoWindow(String Title, String content) {
		DialogPane dialog = new DialogPane();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(Title);
		alert.setContentText(content);
		alert.initStyle(StageStyle.UNDECORATED);
		
		dialog = alert.getDialogPane();
		dialog.getStylesheets().add(PopUpScreen.class.getResource("Style.css").toString());
		dialog.getStyleClass().add("dialog");
		
		alert.showAndWait();
	}
}