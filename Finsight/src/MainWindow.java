<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>

<?import javafx.scene.layout.*?>

<BorderPane fx:id="borderPane" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="600.0" prefWidth="800.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1">
   <top>
      <VBox spacing="5.0">
         <!-- Menu Bar -->
         <MenuBar>
            <menus>
               <Menu text="File">
                  <items>
                     <MenuItem text="Exit" onAction="#exitAction"/>
                  </items>
               </Menu>
               <!-- Add more menu items as needed -->
            </menus>
         </MenuBar>
         <!-- Header Content -->
         <HBox alignment="CENTER" spacing="10.0">
            <Label text="Welcome to FinSight Personal Finance Tracker" style="-fx-font-size: 18pt;" />
         </HBox>
      </VBox>
   </top>
   <center>
      <VBox alignment="CENTER" spacing="20.0">
         <Label text="Income Tracking" />
         <HBox alignment="CENTER" spacing="10.0">
            <Label text="Source:" />
            <TextField fx:id="incomeSourceField" />
            <Label text="Amount:" />
            <TextField fx:id="incomeAmountField" />
            <Button fx:id="addIncomeButton" text="Add Income" />
         </HBox>
         <Separator />
         <Label text="Expense Management" />
         <HBox alignment="CENTER" spacing="10.0">
            <Label text="Category:" />
            <ChoiceBox fx:id="expenseCategoryChoiceBox" />
            <Label text="Amount:" />
            <TextField fx:id="expenseAmountField" />
            <Button fx:id="addExpenseButton" text="Add Expense" />
         </HBox>
         <Separator />
         <Label text="Budget Creation and Monitoring" />
         <HBox alignment="CENTER" spacing="10.0">
            <Label text="Category:" />
            <ChoiceBox fx:id="budgetCategoryChoiceBox" />
            <Label text="Budget Amount:" />
            <TextField fx:id="budgetAmountField" />
            <Button fx:id="setBudgetButton" text="Set Budget" />
         </HBox>
         <Separator />
         <Label text="Financial Insights" />
         <VBox alignment="CENTER" spacing="10.0">
            <Label text="Select Time Period:" />
            <ChoiceBox fx:id="timePeriodChoiceBox" />
            <Button fx:id="generateReportButton" text="Generate Report" />
<!-- Area for displaying generated reports/charts -->
   <right>
      <VBox spacing="10.0">
         <Label text="Financial Insights" />
         <WebView fx:id="reportWebView" minWidth="200.0" prefWidth="300.0" minHeight="400.0" />
      </VBox>
   </right>
</BorderPane>
