package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class AuthorsManager extends Application {
    private TableView<Author> tableView;
    private ObservableList<Author> authorsList;
    private TextField firstNameField;
    private TextField lastNameField;

    @Override
    public void start(Stage primaryStage) {
        tableView = new TableView<>();
        TableColumn<Author, Integer> idColumn = new TableColumn<>("AuthorID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("authorID"));
        TableColumn<Author, String> firstNameColumn = new TableColumn<>("FirstName");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Author, String> lastNameColumn = new TableColumn<>("LastName");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn);
        authorsList = FXCollections.observableArrayList();
        tableView.setItems(authorsList);
        loadAuthors();

        firstNameField = new TextField();
        firstNameField.setPromptText("First Name");
        lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        addButton.setOnAction(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            if (!firstName.isEmpty() && !lastName.isEmpty()) {
                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(
                             "INSERT INTO Authors (FirstName, LastName) VALUES (?, ?)")) {
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.executeUpdate();
                    firstNameField.clear();
                    lastNameField.clear();
                    loadAuthors();
                } catch (SQLException ex) {
                    showError("Add Error", ex.getMessage());
                }
            }
        });

        updateButton.setOnAction(e -> {
            Author selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                if (!firstName.isEmpty() && !lastName.isEmpty()) {
                    try (Connection conn = DatabaseUtil.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(
                                 "UPDATE Authors SET FirstName=?, LastName=? WHERE AuthorID=?")) {
                        pstmt.setString(1, firstName);
                        pstmt.setString(2, lastName);
                        pstmt.setInt(3, selected.getAuthorID());
                        pstmt.executeUpdate();
                        loadAuthors();
                    } catch (SQLException ex) {
                        showError("Update Error", ex.getMessage());
                    }
                }
            }
        });
        deleteButton.setOnAction(e -> {
            Author selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(
                             "DELETE FROM Authors WHERE AuthorID=?")) {
                    pstmt.setInt(1, selected.getAuthorID());
                    pstmt.executeUpdate();
                    loadAuthors();
                } catch (SQLException ex) {
                    showError("Delete Error", ex.getMessage());
                }
            }
        });

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        firstNameField.setText(newSelection.getFirstName());
                        lastNameField.setText(newSelection.getLastName());
                    }
                }
        );

        HBox fieldsBox = new HBox(10, firstNameField, lastNameField);
        HBox buttonsBox = new HBox(10, addButton, updateButton, deleteButton);
        VBox controlsBox = new VBox(10, fieldsBox, buttonsBox);
        controlsBox.setPadding(new Insets(15));
        VBox mainLayout = new VBox(10, tableView, controlsBox);
        mainLayout.setPadding(new Insets(15));

        Scene scene = new Scene(mainLayout, 550, 400);
        primaryStage.setTitle("Authors Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadAuthors() {
        authorsList.clear();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Authors")) {
            while (rs.next()) {
                int id = rs.getInt("AuthorID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                authorsList.add(new Author(id, firstName, lastName));
            }

        } catch (SQLException e) {
            showError("Load Error", e.getMessage());
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
