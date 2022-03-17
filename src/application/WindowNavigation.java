package application;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class WindowNavigation {
	public static void switchToView(String view) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/" + view + ".fxml")));
		Main.primaryStage.setScene(new Scene(root));
		Main.primaryStage.show();
	}
}