package application;

import java.io.IOException;
import java.util.Objects;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowNavigation {
	public static void switchToView(String view) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/" + view + ".fxml")));
		Main.primaryStage.setScene(new Scene(root));
		Main.primaryStage.show();
	}
	
	public static void infoWindow(Stage stage, JFXButton button, Label label, String message) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("/fxml/PopUpScreen.fxml")));
		stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		label.setText(message);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(button.getScene().getWindow());
		stage.showAndWait();
	}
}