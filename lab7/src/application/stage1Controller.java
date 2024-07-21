package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class stage1Controller {
	@FXML
	private TextField tText1;
	@FXML
	private TextField tText2;

	// Event Listener on Button.onAction
	@FXML
	public void btnHelpClicked(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is a help message.");
        alert.showAndWait();
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnNextClicked(ActionEvent event) {
	    
	    Stage primaryStage2=new Stage();
    	Parent p1;
		try {
			p1 = FXMLLoader.load(getClass().getResource("stage2.fxml"));
	    	Scene s1=new Scene(p1);
	        primaryStage2.setScene(s1);
	        primaryStage2.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

