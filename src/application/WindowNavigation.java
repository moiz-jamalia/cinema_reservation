package application;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class WindowNavigation {
	
	public static void switchToView(String view) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/" + view + ".fxml")));
		Main.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/img/cinema/Logo.png")));
		Main.primaryStage.setTitle(view);
		Main.primaryStage.setScene(new Scene(root));
		Main.primaryStage.show();
	}
	
}