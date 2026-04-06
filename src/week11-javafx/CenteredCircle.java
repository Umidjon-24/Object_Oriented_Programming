package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CenteredCircle extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: lightgray;");

        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        circle.centerXProperty().bind(pane.widthProperty().divide(2));

        circle.centerYProperty().bind(pane.heightProperty().divide(2));

        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 300, 300);

        primaryStage.setTitle("Centered Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
