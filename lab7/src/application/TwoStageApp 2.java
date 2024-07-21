package application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class TwoStageApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // First stage
    	Parent p1;
		try {
			p1 = FXMLLoader.load(getClass().getResource("stage1.fxml"));
	    	Scene s1=new Scene(p1);
	        primaryStage.setScene(s1);
	        primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
