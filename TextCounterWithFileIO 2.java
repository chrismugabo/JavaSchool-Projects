 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Dr.RisvanCoskun
 *
 */
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


/**
 * In this program, the user types some text in a TextArea and presses
 * a button.  The program computes and displays the number of lines
 * in the text, the number of words in the text, and the number of
 * characters in the text.  A word is defined to be a sequence of
 * letters, except that an apostrophe with a letter on each side
 * of it is considered to be a letter.  (Thus "can't" is one word,
 * not two.)
 */
public class TextCounterWithFileIO extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private TextArea textInput;     // For the user's input text.

    private Label lineCountLabel;   // For displaying the number of lines.
    private Label wordCountLabel;   // For displaying the number of words.
    private Label charCountLabel;   // For displaying the number of chars.
    private Label dirLabel;         // For displaying the current directory.


    /**
     * The constructor creates components and lays out the window.
     */ 
    public void start(Stage stage) {

        textInput = new TextArea();
        textInput.setPrefRowCount(15);
        textInput.setPrefColumnCount(30);

        /* Create the button and a listener to listen for
             clicks on the button. */

        Button countButton = new Button("Process the Text");
        countButton.setOnAction( e -> processInput() );
        
        Button countButton2 = new Button("Text from a File");
        countButton2.setOnAction( e -> processInputFromFile1() );

        /* Create each of the labels, and set their properties. */
        
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

        /* Use a VBox as the root component. */

        VBox root = new VBox( 4, textInput, new BorderPane(countButton), new BorderPane(countButton2),
                                  lineCountLabel, wordCountLabel, charCountLabel, dirLabel );
        root.setStyle("-fx-background-color: #009; -fx-border-color: #009; -fx-border-width:3px");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CST3102 Lab 8 Line/Word/Char Counter");
        stage.setResizable(false);
        stage.show();

    } // end constructor


    /**
     * This will be called when the user clicks the "Process the Text" button.
     * It gets the text from the text area, counts the number of chars, words, 
     * and lines that it contains, and sets the labels to display the results.
     */
    public void processInput() {

        String text;  // The user's input from the text area.

        int charCt, wordCt, lineCt;  // Char, word, and line counts.

        text = textInput.getText();

        charCt = text.length();  // The number of characters in the
                                 //    text is just its length.

        /* Compute the wordCt by counting the number of characters
              in the text that lie at the beginning of a word.  The
              beginning of a word is a letter such that the preceding
              character is not a letter.  This is complicated by two
              things:  If the letter is the first character in the
              text, then it is the beginning of a word.  If the letter
              is preceded by an apostrophe, and the apostrophe is
              preceded by a letter, than its not the first character
              in a word.
         */

        wordCt = 0;
        for (int i = 0; i < charCt; i++) {
            boolean startOfWord;  // Is character i the start of a word?
            if ( Character.isLetter(text.charAt(i)) == false )
                startOfWord = false;  // No.  It's not a letter.
            else if (i == 0)
                startOfWord = true;   // Yes.  It's a letter at start of text.
            else if ( Character.isLetter(text.charAt(i-1)) )
                startOfWord = false;  // No.  It's a letter preceded by a letter.
            else if ( text.charAt(i-1) == '\'' && i > 1 
                    && Character.isLetter(text.charAt(i-2)) )
                startOfWord = false;  // No.  It's a continuation of a word
                                      //      after an apostrophe.
            else
                startOfWord = true;   // Yes.  It's a letter preceded by
                                      //       a non-letter.
            if (startOfWord)
                wordCt++;
        }

        /* The number of lines is just one plus the number of times the
              end of line character, '\n', occurs in the text. */

        lineCt = 1;
        for (int i = 0; i < charCt; i++) {
            if (text.charAt(i) == '\n')
                lineCt++;
        }

        /* Set the labels to display the data. */

        lineCountLabel.setText("  Number of lines:  " + lineCt);
        wordCountLabel.setText("  Number of words:  " + wordCt);
        charCountLabel.setText("  Number of chars:  " + charCt);
        dirLabel.setText("  Current file:  " + "N/A");

    }  // end processInput()
    
    /**
     * This will be called when the user clicks the "Process the Text" button.
     * It gets the text from the text area, counts the number of chars, words, 
     * and lines that it contains, and sets the labels to display the results.
     */
    public void processInputFromFile1() {
    
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            ); 
        File selectedFile = fileChooser.showOpenDialog(null);
        
        /* Set the labels to display the data. */
        dirLabel.setText("  Current file:  " + fileChooser.getTitle());
    }

    // processInputFromFile


 // end class TextCounter
/**
 * This will be called when the user clicks the "Text from a File" button.
 * It prompts the user to select a text file, reads its contents, and
 * counts the number of characters, words, and lines. Then, it sets the
 * labels to display the statistics.
 */
    public void processInputFromFile1(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                String text = content.toString();
                int charCt = text.length();
                int wordCt = countWords(text);
                int lineCt = countLines(text);
                textInput.setText(text);
                lineCountLabel.setText("  Number of lines:  " + lineCt);
                wordCountLabel.setText("  Number of words:  " + wordCt);
                charCountLabel.setText("  Number of chars:  " + charCt);
                dirLabel.setText("  Current file:  " + selectedFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int countWords(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        return tokenizer.countTokens();
    }

    private int countLines(String text) {
        int lineCt = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n')
                lineCt++;
        }
        return lineCt;
    }

}