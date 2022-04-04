package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage stage) {
		primaryStage = stage;
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
			primaryStage.initStyle(StageStyle.UNDECORATED);               
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/cinema/Logo.png")));
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}