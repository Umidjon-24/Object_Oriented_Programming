package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class TitlesBrowser extends Application {
    public static class AuthorBook {
        private String firstName;
        private String lastName;
        private String isbn;
        private String title;

        public AuthorBook(String firstName, String lastName, String isbn, String title) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.isbn = isbn;
            this.title = title;
        }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getIsbn() { return isbn; }
        public String getTitle() { return title; }
    }
    private TableView<AuthorBook> tableView;
    private TextField searchField;

    @Override
    public void start(Stage primaryStage) {
        tableView = new TableView<>();
        tableView.setPrefWidth(230);
        TableColumn<AuthorBook, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<AuthorBook, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<AuthorBook, String> isbnCol = new TableColumn<>("ISBN");
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        TableColumn<AuthorBook, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setPrefWidth(230);
        tableView.getColumns().addAll(firstNameCol, lastNameCol, isbnCol, titleCol);

        Label promptLabel = new Label("Last-name prefix:");
        searchField = new TextField();
        searchField.setPrefWidth(150);
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String pattern = searchField.getText().trim();
            if (pattern.isEmpty()) {
                loadData("%");
            } else {
                loadData(pattern + "%");
            }
        });

        HBox searchBox = new HBox(10, promptLabel, searchField, searchButton);
        searchBox.setPadding(new Insets(10));
        VBox root = new VBox(10, searchBox, tableView);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 640, 400);
        primaryStage.setTitle("Titles Browser");
        primaryStage.setScene(scene);
        primaryStage.show();
        loadData("%");
    }

    private void loadData(String pattern) {
        tableView.getItems().clear();
        String query = """
            SELECT a.FirstName, a.LastName, t.ISBN, t.Title
            FROM Authors a
            INNER JOIN AuthorISBN ai ON a.AuthorID = ai.AuthorID
            INNER JOIN Titles t ON ai.ISBN = t.ISBN
            WHERE a.LastName LIKE ?
            ORDER BY a.LastName, a.FirstName
            """;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pattern);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String isbn = rs.getString("ISBN");
                String title = rs.getString("Title");
                tableView.getItems().add(new AuthorBook(firstName, lastName, isbn, title));
            }

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
