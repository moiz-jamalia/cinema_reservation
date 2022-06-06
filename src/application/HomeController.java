package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import javafx.event.ActionEvent;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class HomeController implements Initializable{
	
	@FXML
	private StackPane stackPane;
	
	@FXML 
	private AnchorPane mainHomePane;
	
	@FXML
	private AnchorPane navigationPane;
	
	@FXML
	private JFXHamburger ham;
	
	@FXML
	private JFXButton profilbtn;
	
	@FXML
	private JFXButton moviebtn;
	
	@FXML 
	private JFXButton logoutbtn;
	
	@FXML
	private JFXButton reservationbtn;
	
	public void initialize(URL url, ResourceBundle rb) {
		HamburgerSlideCloseTransition slideClose = new HamburgerSlideCloseTransition(ham);
		TranslateTransition tt = new TranslateTransition(Duration.seconds(10), navigationPane);
		tt.setByX(-190);
		
		slideClose.setRate(-1);
		ham.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			slideClose.setRate(slideClose.getRate()*-1);
			slideClose.play();
			tt.setByX(190);
		});
	}
	
	@FXML
	public void profileAction() {
		
	}
	
	@FXML
	public void movieAction() {
		
	}
	
	@FXML
	public void reservationAction() {
		
	}
	
	@FXML
	public void logOutAction(ActionEvent event) {
		System.out.println("Logout");
		try {
			WelcomeScreenController.setText("goodbye " + WelcomeScreenController.username);
			WindowNavigation.switchToView("WelcomeScreen");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}