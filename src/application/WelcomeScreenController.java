package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class WelcomeScreenController implements Initializable {

	@FXML
	private StackPane stackPane;

	@FXML
	private AnchorPane mainWelcomePane;

	@FXML
	private ImageView imageView;
	
	@FXML
	private Label userName;
	
	static String username;
	
	static String welcomeGoodbye;

	@FXML
	private ProgressIndicator pi = new ProgressIndicator();

	public void initialize(URL url, ResourceBundle rb) {
		int duration = 7000;
		String username = null;  
		try {
			username = DatabaseConnection.getFullName(WelcomeScreenController.username);
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println(WelcomeScreenController.username);
		userName.setText(welcomeGoodbye + " " + username);
		ArrayList<Object> fade = new ArrayList<>();
		fade.add(imageView);
		fade.add(userName);
		
		for (Object obj : fade) {
			FadeTransition fadeIn = new FadeTransition();
			fadeIn.setNode((Node) obj);
			fadeIn.setDuration(Duration.millis(duration));
			fadeIn.setCycleCount(1);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);

			fadeIn.play();

			FadeTransition fadeOut = new FadeTransition();
			fadeOut.setNode((Node) obj);
			fadeOut.setDuration(Duration.millis(duration));
			fadeOut.setCycleCount(1);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);

			fadeIn.setOnFinished((e) -> {
				fadeOut.play();
			});

			fadeOut.setOnFinished((e) -> {
				try {
					WindowNavigation.switchToView("Home");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		}
	}
	
	public static void setText(String text) {
		String[] str = text.split(text);
		welcomeGoodbye = str[0];
		username = str[1];
	}
}