package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.awt.Label;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javafx.event.ActionEvent;

public class stage2Controller {
    @FXML
    private Button bButton1;
	// Event Listener on Button.onAction
	@FXML
	public void btnCloseClicked(ActionEvent event) {
		Stage stage = (Stage) bButton1.getScene().getWindow();
        // Close the stage
        stage.close();
		
	}
	// add a few more buttons in the grid and attach them to some dialogs/alerts (use 5 of them)
	//Without Header Text
	//Warning Dialog
	@FXML
    public void btnWarningDialog(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is a warning message!");
        alert.showAndWait();
    }
	//Exception Dialog
	   @FXML
	    private void btnExceptionDialog(ActionEvent event) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Exception Dialog");
	        alert.setHeaderText(null);
	        alert.setContentText("An error occurred!");
	        alert.showAndWait();
	    }
	//Confirmation Dialog
	   @FXML
	    private void btnConfirmationDialog(ActionEvent event) {
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Confirmation Dialog");
	        alert.setHeaderText(null);
	        alert.setContentText("Are you sure you want to proceed?");
	        alert.showAndWait();
	    }
	//Confirmation Dialog with Custom Actions
	//Text Input Dialog
	 @FXML
	    private void btnTextInputDialog(ActionEvent event) {
	        TextInputDialog dialog = new TextInputDialog();
	        dialog.setTitle("Text Input Dialog");
	        dialog.setHeaderText(null);
	        dialog.setContentText("Please enter your name:");
	        Optional<String> result = dialog.showAndWait();
	        result.ifPresent(name -> System.out.println("Entered name: " + name));
	    }
	//Choice Dialog
	 @FXML
	    private void btnChoiceDialog(ActionEvent event) {
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Choice Dialog");
	        alert.setHeaderText(null);
	        alert.setContentText("Choose your preferred option:");
	        ButtonType option1 = new ButtonType("Option 1");
	        ButtonType option2 = new ButtonType("Option 2");
	        ButtonType option3 = new ButtonType("Option 3");
	        alert.getButtonTypes().setAll(option1, option2, option3);
	        Optional<ButtonType> result = alert.showAndWait();
	        if (result.isPresent()) {
	            if (result.get() == option1) {
	                System.out.println("Option 1 chosen");
	            } else if (result.get() == option2) {
	                System.out.println("Option 2 chosen");
	            } else if (result.get() == option3) {
	                System.out.println("Option 3 chosen");
	            }
	        }
	    }
	//Custom Login Dialog
	//Styling the Dialogs
	//Minimal Decorations
	
	
}
