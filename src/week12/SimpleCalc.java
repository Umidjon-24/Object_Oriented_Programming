package org.example;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalc extends Application {
    private TextField number1;
    private TextField number2;
    private TextField resultField;

    @Override
    public void start(Stage primaryStage){
        Label label1 = new Label("Number 1");
        Label label2 = new Label("Number 2");
        Label result = new Label("Result");
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(actionEvent -> Sum());
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(actionEvent -> Clear());

        resultField = new TextField();
        resultField.setEditable(false);
        number1 = new TextField();
        number2 = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(label1, 0, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(result, 0, 2);
        gridPane.add(number1, 1, 0);
        gridPane.add(number2, 1,1);
        gridPane.add(resultField, 1, 2);
        gridPane.add(calculateButton, 0, 3);
        gridPane.add(clearButton, 1,3);

        Button button = new Button("Calculate");

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void Sum(){
        try{
            double num1 = Double.parseDouble(number1.getText());
            double num2 = Double.parseDouble(number2.getText());
            Double sum = num1 + num2;
            resultField.setText(sum.toString());
        } catch (NumberFormatException e){
            resultField.setText("Invalid Input!");
        }
    }
    private void Clear(){
        number1.clear();
        number2.clear();
        resultField.clear();
    }
    public static void main(String[] args){
        launch(args);
    }
}
