package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;

public class DiagonalLine extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        Line line = new Line(0, 0, 0, 0);
        line.endXProperty().bind(pane.widthProperty());
        line.endYProperty().bind(pane.heightProperty());
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(3);

        pane.getChildren().add(line);

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Dioganal Line");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
