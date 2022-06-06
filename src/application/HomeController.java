package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class HomeController implements Initializable{
	
	@FXML
	private StackPane stackPane;
	
	@FXML 
	private AnchorPane mainHomePane;
	
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
		slideClose.setRate(-1);
		ham.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			slideClose.setRate(slideClose.getRate()*-1);
			slideClose.play();
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
	public void logOutAction() {
		
	}
}