package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable{
	
	@FXML
    private JFXHamburger ham;

    @FXML
    private JFXButton logoutbtn;

    @FXML
    private AnchorPane mainHomePane;

    @FXML
    private JFXButton moviebtn;

    @FXML
    private JFXButton profilbtn;

    @FXML
    private JFXButton reservationbtn;

    @FXML
    private StackPane stackPane;
    
    @FXML
    private JFXDrawer navigation;
	
	public void initialize(URL url, ResourceBundle rb) {
		HamburgerSlideCloseTransition slideClose = new HamburgerSlideCloseTransition(ham);
		
		try {
			VBox vbox = FXMLLoader.load(getClass().getResource("/fxml/Navigationbar.fxml"));
			navigation.setSidePane(vbox);
			
			for (Node node : vbox.getChildren()) {
				if (node.getAccessibleText() != null) {
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
						switch (node.getAccessibleText()) {
						case "Profile": try {
								WindowNavigation.switchToView("Profile");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						
						case "Movies": try {
								WindowNavigation.switchToView("Movies");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						
						case "Reservation": try {
								WindowNavigation.switchToView("Reservation");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						
						case "LogOut": try {
							WelcomeScreenController.setText("Goodbye " + WelcomeScreenController.username);
							WindowNavigation.switchToView("WelcomeScreen");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + node);
						}
					});
				}
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		slideClose.setRate(-1);
		ham.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			slideClose.setRate(slideClose.getRate()*-1);
			slideClose.play();
			
			if (navigation.isOpened())navigation.close();
			else navigation.open();
		});
		
		navigation.setOnDrawerOpening(event -> {
			AnchorPane.setRightAnchor(navigation, 0.0);
			AnchorPane.setLeftAnchor(navigation, 0.0);
			AnchorPane.setTopAnchor(navigation, 0.0);
			AnchorPane.setBottomAnchor(navigation, 0.0);
		});
		
		navigation.setOnDrawerClosed(event -> {
			AnchorPane.clearConstraints(navigation);
			AnchorPane.setLeftAnchor(navigation, -255.0);
			AnchorPane.setTopAnchor(navigation, 0.0);
			AnchorPane.setBottomAnchor(navigation, 0.0);
		});
	}
}