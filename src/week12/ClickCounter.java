package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class ClickCounter extends Application {
    private int counter = 0;
    @Override
    public void start(Stage primaryStage){
        Label label = new Label("Clicks: 0");
        label.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Button button = new Button("Click me!");
        button.setOnAction(actionEvent -> {
            counter++;
            label.setText("Clicks: " + counter);
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(30));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(label, button);

        Scene scene = new Scene(vBox, 300, 200);

        primaryStage.setTitle("Click Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
