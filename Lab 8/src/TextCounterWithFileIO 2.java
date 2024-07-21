 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TextCounterWithFileIO extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextArea textInput;
    private Label lineCountLabel;
    private Label wordCountLabel;
    private Label charCountLabel;
    private Label dirLabel;

    public void start(Stage stage) {

        textInput = new TextArea();
        textInput.setWrapText(false); // Set wrapText property to false
        textInput.setPrefRowCount(15);
        textInput.setPrefColumnCount(30);

        Button countButton = new Button("Process the Text");
        countButton.setOnAction(e -> processInput());

        Button countButton2 = new Button("Text from a File");
        countButton2.setOnAction(e -> processInputFromFile1(stage));

        String style = "-fx-padding: 5px; -fx-font: bold 14pt serif; -fx-background-color: white";

        lineCountLabel = new Label("  Number of lines:");
        lineCountLabel.setStyle(style);
        lineCountLabel.setMaxWidth(1000);

        wordCountLabel = new Label("  Number of words:");
        wordCountLabel.setStyle(style);
        wordCountLabel.setMaxWidth(1000);

        charCountLabel = new Label("  Number of chars:");
        charCountLabel.setStyle(style);
        charCountLabel.setMaxWidth(1000);

        dirLabel = new Label("  Current file:");
        dirLabel.setStyle(style);
        dirLabel.setMaxWidth(1000);

        VBox root = new VBox(4, textInput, new BorderPane(countButton), new BorderPane(countButton2),
                lineCountLabel, wordCountLabel, charCountLabel, dirLabel);
        root.setStyle("-fx-background-color: #009; -fx-border-color: #009; -fx-border-width:3px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CST3102 Lab 8 Line/Word/Char Counter");
        stage.setResizable(false);
        stage.show();

    }

    public void processInput() {
        String text = textInput.getText();
        int charCt = text.length();
        int wordCt = countWords(text);
        int lineCt = countLines(text);

        lineCountLabel.setText("  Number of lines:  " + lineCt);
        wordCountLabel.setText("  Number of words:  " + wordCt);
        charCountLabel.setText("  Number of chars:  " + charCt);
        dirLabel.setText("  Current file:  N/A");
    }

    public void processInputFromFile1(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.showOpenDialog(stage);

        // Check if a file is selected
        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder fileContent = new StringBuilder();
                String line;
                int charCount = 0;
                int wordCount = 0;
                int lineCount = 0;

                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    // Append newline character after each line
                    fileContent.append(line).append(System.lineSeparator()); // Use System.lineSeparator()
                    // Update character count
                    charCount += line.length();
                    // Split the line into words and update word count
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                    // Update line count
                    lineCount++;
                }


                // Set the file content to the TextInput area
                textInput.setText(fileContent.toString());
                // Update the label to display the current file name
                dirLabel.setText("  Current file:  " + selectedFile.getName());
                // Update the labels to display the counts
                lineCountLabel.setText("  Number of lines:  " + lineCount);
                wordCountLabel.setText("  Number of words:  " + wordCount);
                charCountLabel.setText("  Number of chars:  " + charCount);

            } catch (IOException e) {
                e.printStackTrace(); // Handle file reading errors
            }
        }
    }

    // Helper method to count words
    private int countWords(String text) {
        // Words are separated by whitespace
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Helper method to count lines
    private int countLines(String text) {
        // Lines are separated by newline characters
        String[] lines = text.split("\\n");
        return lines.length;
    }

}

