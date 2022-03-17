package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage stage) {
		primaryStage = stage;
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
			primaryStage.initStyle(StageStyle.UNDECORATED);
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
