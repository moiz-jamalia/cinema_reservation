package application;

import java.io.IOException;
import java.util.Objects;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopUpScreenController {
	
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
	
	public static void infoWindow(JFXButton button, String message) throws IOException, NullPointerException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("/fxml/PopUpScreen.fxml")));
		infoLabel = new Label();
		infoLabel.setText(message);
		infoLabel.setTextFill(javafx.scene.paint.Color.WHITE);
		System.out.println(infoLabel.getText());
		stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("/img/cinema/Logo.png")));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(button.getScene().getWindow());
		stage.showAndWait();
	}
}