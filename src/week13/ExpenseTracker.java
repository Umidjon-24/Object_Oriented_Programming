package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;

public class ExpenseTracker extends Application {

    private TextField categoryField = new TextField();
    private TextField amountField = new TextField();
    private TextField noteField = new TextField();
    private Label statusLabel = new Label();
    private TextArea summaryArea = new TextArea();
    private final String FILE_NAME = "expenses.txt";

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPadding(new Insets(20));
        grid.add(new Label("Category:"), 0, 0);
        grid.add(categoryField, 1, 0);
        grid.add(new Label("Amount:"), 0, 1);
        grid.add(amountField, 1, 1);
        grid.add(new Label("Note:"), 0, 2);
        grid.add(noteField, 1, 2);

        Button addBtn = new Button("Add Expense");
        Button summaryBtn = new Button("Show Summary");
        Button clearBtn = new Button("Clear Fields");
        summaryArea.setEditable(false);
        summaryArea.setPrefHeight(200);

        addBtn.setOnAction(e -> {
            String category = categoryField.getText().trim();
            String amountText = amountField.getText().trim();
            String note = noteField.getText().trim();

            if (category.isEmpty() || amountText.isEmpty()) {
                statusLabel.setText("Category and Amount required!");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            try {
                double amount = Double.parseDouble(amountText);
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
                writer.write(category + "|" + amount + "|" + note);
                writer.newLine();
                writer.close();
                statusLabel.setText("Saved!");
                statusLabel.setStyle("-fx-text-fill: green;");
            } catch (Exception ex) {
                statusLabel.setText("Invalid amount!");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        });
        summaryBtn.setOnAction(e -> {
            summaryArea.clear();
            double total = 0;

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    if (parts.length >= 2) {
                        String category = parts[0];
                        double amount = Double.parseDouble(parts[1]);
                        String note = parts.length > 2 ? parts[2] : "";

                        total += amount;

                        summaryArea.appendText(
                                category + " --- $" + String.format("%.2f", amount) +
                                        (note.isEmpty() ? "" : " (" + note + ")") + "\n"
                        );
                    }
                }

                reader.close();
                summaryArea.appendText("\nTotal: $" + String.format("%.2f", total));
            } catch (IOException ex) {
                summaryArea.setText("No data found.");
            }
        });
        clearBtn.setOnAction(e -> {
            categoryField.clear();
            amountField.clear();
            noteField.clear();
            statusLabel.setText("");
        });
        VBox root = new VBox(12, grid, addBtn, summaryBtn, clearBtn, statusLabel, summaryArea);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 460, 420);
        stage.setTitle("Expense Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
