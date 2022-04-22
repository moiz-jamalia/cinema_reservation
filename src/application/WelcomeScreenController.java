package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private Label UserName;

	@FXML
	//instead of JFXProgressBar progressbar until the problem is solved
	private ProgressIndicator progressindicator;

	public void initialize(URL url, ResourceBundle rb) {
		int duration = 7000;
		progressindicator.setVisible(false);
		Timeline timeline = animateProgressbar();
		FadeTransition fadeIn = new FadeTransition();
		fadeIn.setNode(imageView);
		fadeIn.setDuration(Duration.millis(duration));
		fadeIn.setCycleCount(1);
		fadeIn.setFromValue(0);
		fadeIn.setToValue(1);

		fadeIn.play();

		FadeTransition fadeOut = new FadeTransition();
		fadeOut.setNode(imageView);
		fadeOut.setDuration(Duration.millis(duration));
		fadeOut.setCycleCount(1);
		fadeOut.setFromValue(1);
		fadeOut.setToValue(0);

		fadeIn.setOnFinished((e) -> {
			fadeOut.play();
			timeline.play();
		});

		fadeOut.setOnFinished((e) -> {
			try {
				WindowNavigation.switchToView("Home");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	//using ProgressBar instead of JFXProgressBar until the problem is solved
	//with ProgessBar it works fine but it's not that what I imagined to use
	//Caused by: java.lang.IllegalAccessError: 
	//class com.jfoenix.skins.JFXProgressBarSkin (in module com.jfoenix)cannot access class com.sun.javafx.scene.NodeHelper (in module javafx.graphics)
	//because module javafx.graphics does not export com.sun.javafx.scene to module com.jfoenix
	private Timeline animateProgressbar() {
		progressindicator.setVisible(true);
		Timeline tl = new Timeline();
		
		progressindicator.setProgress(0.25);
		tl.setCycleCount(1);
		tl.getKeyFrames().add(new KeyFrame(Duration.millis(2400)));
		
		return tl;
	}
}