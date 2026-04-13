package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KeyboardMove extends Application {
    private Rectangle rectangle;
    private TextField positionField;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: white;");
        rectangle = new Rectangle(220, 180, 60, 40);
        rectangle.setFill(Color.BLUE);
        pane.getChildren().add(rectangle);

        positionField = new TextField();
        positionField.setEditable(false);
        updatePositionField();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(positionField);
        BorderPane.setAlignment(positionField, Pos.CENTER);

        Scene scene = new Scene(borderPane, 500, 400);
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            double moveDistance = 10;

            if (code == KeyCode.UP) {
                rectangle.setY(rectangle.getY() - moveDistance);
            } else if (code == KeyCode.DOWN) {
                rectangle.setY(rectangle.getY() + moveDistance);
            } else if (code == KeyCode.LEFT) {
                rectangle.setX(rectangle.getX() - moveDistance);
            } else if (code == KeyCode.RIGHT) {
                rectangle.setX(rectangle.getX() + moveDistance);
            }

            if (rectangle.getX() < 0) {
                rectangle.setX(0);
            } else if (rectangle.getX() > 440) {
                rectangle.setX(440);
            }
            if (rectangle.getY() < 0) {
                rectangle.setY(0);
            } else if (rectangle.getY() > 360) {
                rectangle.setY(360);
            }

            updatePositionField();
        });

        primaryStage.setTitle("Keyboard Move");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.getRoot().requestFocus();
    }

    private void updatePositionField() {
        positionField.setText(String.format("X: %.0f Y: %.0f", rectangle.getX(), rectangle.getY()));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
