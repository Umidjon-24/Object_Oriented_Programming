package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rect = new Rectangle(80, 40);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.RED);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(2);

        Circle circle = new Circle(40);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);

        HBox hBox = new HBox(20, rect, circle);
        hBox.setPadding(new Insets(20));


        primaryStage.setTitle("Shapes");
        primaryStage.setScene(new Scene(hBox, 400, 200));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
