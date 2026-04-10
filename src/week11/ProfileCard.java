package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProfileCard extends Application{
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(12));
        hBox.setStyle("-fx-background-color: #2C3E50;");
        hBox.setAlignment(Pos.TOP_CENTER);
        Label nameLabel = new Label("Umidjon Xusanov");
        nameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        nameLabel.setTextFill(Color.WHITE);
        hBox.getChildren().add(nameLabel);
        borderPane.setTop(hBox);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        Label deptLabel = new Label("Department");
        Label major = new Label("Economics");
        gridPane.add(deptLabel, 0, 0);
        gridPane.add(major, 1, 0);
        Label yearLabel = new Label("Year");
        Label yearValue = new Label("Junior");
        gridPane.add(yearLabel, 0, 1);
        gridPane.add(yearValue, 1, 1);

        Label gpa = new Label("GPA");
        Label gpaValue = new Label("4");
        gridPane.add(gpa, 0, 2);
        gridPane.add(gpaValue, 1, 2);
        borderPane.setCenter(gridPane);

        Label uniLabel  = new Label("New Uzbekistan University");
        uniLabel.setPadding(new Insets(8));
        uniLabel.setAlignment(Pos.CENTER);
        uniLabel.setStyle("-fx-background-color: #ECF0F1; -fx-font-size: 13;");
        uniLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        uniLabel.setMaxWidth(Double.MAX_VALUE);
        borderPane.setBottom(uniLabel);

        Scene scene = new Scene(borderPane, 400, 250);

        primaryStage.setTitle("Profile Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
