package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class ContactBook extends Application {
    private Stage stage;
    private ListView<String> listView = new ListView<>();
    private Label statusLabel = new Label();
    private final String FILE_NAME = "contacts.txt";

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        Scene scene1 = createListScene();
        stage.setScene(scene1);
        stage.setTitle("Contact Book");
        stage.show();
        loadContacts();
    }

    private Scene createListScene() {
        Button addBtn = new Button("Add New");
        Button deleteBtn = new Button("Delete Selected");
        Button refreshBtn = new Button("Refresh");
        addBtn.setOnAction(e -> stage.setScene(createAddScene()));
        deleteBtn.setOnAction(e -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                statusLabel.setText("Select a contact first.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            try {
                ArrayList<String> lines = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
                String line;
                while ((line = reader.readLine()) != null) {
                    String formatted = formatLine(line);
                    if (!formatted.equals(selected)) {
                        lines.add(line);
                    }
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
                writer.close();
                loadContacts();
                statusLabel.setText("Deleted.");
                statusLabel.setStyle("-fx-text-fill: green;");
            } catch (IOException ex) {
                statusLabel.setText("Error deleting.");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        });
        refreshBtn.setOnAction(e -> loadContacts());

        VBox root = new VBox(16, listView, addBtn, deleteBtn, refreshBtn, statusLabel);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        return new Scene(root, 480, 380);
    }
    private Scene createAddScene() {
        TextField nameField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();
        Label formStatus = new Label();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Phone:"), 0, 1);
        grid.add(phoneField, 1, 1);
        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        Button saveBtn = new Button("Save");
        Button cancelBtn = new Button("Cancel");
        saveBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                formStatus.setText("All fields required.");
                formStatus.setStyle("-fx-text-fill: red;");
                return;
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
                writer.write(name + "|" + phone + "|" + email);
                writer.newLine();
                writer.close();
                loadContacts();
                stage.setScene(createListScene());
            } catch (IOException ex) {
                formStatus.setText("Error saving.");
                formStatus.setStyle("-fx-text-fill: red;");
            }
        });
        cancelBtn.setOnAction(e -> stage.setScene(createListScene()));
        VBox root = new VBox(16, grid, saveBtn, cancelBtn, formStatus);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 480, 380);
    }
    private void loadContacts() {
        listView.getItems().clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                listView.getItems().add(formatLine(line));
            }
            reader.close();
        } catch (IOException e) {
            statusLabel.setText("Error loading file.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }
    private String formatLine(String line) {
        String[] parts = line.split("\\|");
        if (parts.length >= 3) {
            return parts[0] + " --- " + parts[1] + "@" + parts[2];
        }
        return line;
    }
    public static void main(String[] args) {
        launch();
    }
}
