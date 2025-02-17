import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.lang.Math;

public class JavaFXCalculator extends Application {
    private TextField tfDisplay;    // display textfield
    private Button[] btns;          // 20 buttons
    private String[] btnLabels = {  // Labels of 20 buttons
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "C", "0", "=", "/",
        "1/x", "x^2", "√", "x^y"
    };
    // For computation
    private double result = 0;      // Result of computation
    private String inStr = "0";     // Input number as String
    // Previous operator: ' '(nothing), '+', '-', '*', '/', '='
    private char lastOperator = ' ';

    // Event handler for all the buttons
    EventHandler<ActionEvent> handler = evt -> {
        String currentBtnLabel = ((Button) evt.getSource()).getText();
        switch (currentBtnLabel) {
            // Number buttons
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (inStr.equals("0")) {
                    inStr = currentBtnLabel;  // no leading zero
                } else {
                    inStr += currentBtnLabel; // append input digit
                }
                tfDisplay.setText(inStr);
                // Clear buffer if last operator is '='
                if (lastOperator == '=') {
                    result = 0;
                    lastOperator = ' ';
                }
                break;

            // Operator buttons: '+', '-', 'x', '/' and '='
            case "+":
            case "-":
            case "x":
            case "/":
            case "=":
                compute();
                lastOperator = currentBtnLabel.charAt(0);
                break;

            // Clear button
            case "C":
                result = 0;
                inStr = "0";
                lastOperator = ' ';
                tfDisplay.setText("0");
                break;

            // New operators/operations
            case "1/x":
                result = 1 / Double.parseDouble(inStr);
                tfDisplay.setText(result + "");
                break;
            case "x^2":
                result = Math.pow(Double.parseDouble(inStr), 2);
                tfDisplay.setText(result + "");
                break;
            case "√":
                result = Math.sqrt(Double.parseDouble(inStr));
                tfDisplay.setText(result + "");
                break;
            case "x^y":
                lastOperator = '^';
                break;
        }
    };

    // User pushes '+', '-', '*', '/' or '=' button.
    // Perform computation on the previous result and the current input number,
    // based on the previous operator.
    private void compute() {
        double inNum = Double.parseDouble(inStr);
        inStr = "0";
        if (lastOperator == ' ') {
            result = inNum;
        } else if (lastOperator == '+') {
            result += inNum;
        } else if (lastOperator == '-') {
            result -= inNum;
        } else if (lastOperator == '*') {
            result *= inNum;
        } else if (lastOperator == '/') {
            result /= inNum;
        } else if (lastOperator == '=') {
            // Keep the result for the next operation
        } else if (lastOperator == '^') {
            result = Math.pow(result, inNum);
        }
        tfDisplay.setText(result + "");
    }

    // Setup the UI
    @Override
    public void start(Stage primaryStage) {
        // Setup the Display TextField
        tfDisplay = new TextField("0");
        tfDisplay.setEditable(false);
        tfDisplay.setAlignment(Pos.CENTER_RIGHT);

        // Setup a GridPane for 5x4 Buttons
        int numCols = 4;
        int numRows = 5;
        GridPane paneButton = new GridPane();
        paneButton.setPadding(new Insets(15, 0, 15, 0));  // top, right, bottom, left
        paneButton.setVgap(5);  // Vertical gap between nodes
        paneButton.setHgap(5);  // Horizontal gap
        // Setup 5 columns of equal width, fill parent
        ColumnConstraints[] columns = new ColumnConstraints[numCols];
        for (int i = 0; i < numCols; ++i) {
            columns[i] = new ColumnConstraints();
            columns[i].setHgrow(Priority.ALWAYS);  // Allow column to grow
            columns[i].setFillWidth(true);  // Ask nodes to fill space for column
            paneButton.getColumnConstraints().add(columns[i]);
        }

        // Setup 20 Buttons and add to GridPane; and event handler
        btns = new Button[20];
        for (int i = 0; i < btns.length; ++i) {
            btns[i] = new Button(btnLabels[i]);
            btns[i].setOnAction(handler);  // Register event handler
            btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  // full-width
            if (i < 4)
                paneButton.add(btns[i], i, 0); // control, col, row
            else if (i < 8)
                paneButton.add(btns[i], i - 4, 1);
            else if (i < 12)
                paneButton.add(btns[i], i - 8, 2);
            else if (i < 16)
                paneButton.add(btns[i], i - 12, 3);
            else
                paneButton.add(btns[i], i - 16, 4);
        }

        // Setup the scene graph rooted at a BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15, 15, 15, 15));  // top, right, bottom, left
        root.setTop(tfDisplay);     // Top zone contains the TextField
        root.setCenter(paneButton); // Center zone contains the GridPane of Buttons

        // Set up scene and stage
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}