package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BuyController {

    @FXML
    private JFXButton profilbtn;
    
    @FXML
    private JFXButton cancelbtn;

    @FXML
    public void profileAction(ActionEvent event) {

    }
    
    @FXML
    public void cancelAction(ActionEvent event) {
    	try {
			WindowNavigation.switchToView("Home");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	
}
