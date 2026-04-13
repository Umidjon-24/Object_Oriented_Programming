package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {
    private Circle circle;
    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: white;");

        circle = new Circle(250, 200, 40);
        circle.setFill(Color.CORAL);

        pane.getChildren().add(circle);

        pane.setOnMousePressed(event -> {
            offsetX = event.getSceneX() - circle.getCenterX();
            offsetY = event.getSceneY() - circle.getCenterY();
        });

        pane.setOnMouseDragged(event -> {
            circle.setFill(Color.TOMATO);
            circle.setCenterX(event.getSceneX() - offsetX);
            circle.setCenterY(event.getSceneY() - offsetY);
        });

        pane.setOnMouseReleased(event -> {
            circle.setFill(Color.CORAL);
        });

        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Draggable Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
