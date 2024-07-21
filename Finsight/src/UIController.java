import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UIController {

    @FXML
    private TextField incomeSourceField;

    @FXML
    private TextField incomeAmountField;

    @FXML
    private Button addIncomeButton;

    @FXML
    private void initialize() {
        addIncomeButton.setOnAction(event -> addIncome());
    }

    private void addIncome() {
        String source = incomeSourceField.getText();
        String amountStr = incomeAmountField.getText();

        if (source.isEmpty() || amountStr.isEmpty()) {
            showAlert("Error", "Please enter both source and amount.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            // Call method to add income to the system
            // Example: IncomeManager.addIncome(source, amount);
            showAlert("Success", "Income added successfully.");
            incomeSourceField.clear();
            incomeAmountField.clear();
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid amount.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
