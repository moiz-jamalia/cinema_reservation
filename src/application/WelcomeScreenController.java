package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXProgressBar;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class WelcomeScreenController implements Initializable{

	@FXML
	private StackPane stackPane;
	
	@FXML
	private AnchorPane mainWelcomePane;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private Label UserName;
	
	@FXML
	private JFXProgressBar progressbar;
	
	public void initialize(URL url, ResourceBundle rb) {
		splashScreen();
	}
	
	private void splashScreen() {
		new Thread();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
					FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), Main.primaryStage.getScene().getRoot());
					fadeIn.setFromValue(0);
					fadeIn.setToValue(1);
					fadeIn.setCycleCount(1);
					
					FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), Main.primaryStage.getScene().getRoot());
					fadeOut.setFromValue(1);
					fadeOut.setToValue(0);
					fadeOut.setCycleCount(1);
					
					fadeIn.play();
					
					fadeIn.setOnFinished((e)->{
						fadeOut.play();
					});
					WindowNavigation.switchToView("Home");
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}