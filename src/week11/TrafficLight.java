package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TrafficLight extends Application{
    @Override
    public void start(Stage primaryStage){
        Circle redLight = new Circle(30);
        redLight.setFill(Color.RED);
        redLight.setStroke(Color.BLACK);
        redLight.setStrokeWidth(2);
        redLight.setOpacity(1.0);

        Circle yellowLight = new Circle(30);
        yellowLight.setFill(Color.YELLOW);
        yellowLight.setStroke(Color.BLACK);
        yellowLight.setStrokeWidth(2);
        yellowLight.setOpacity(0.3);

        Circle greenLight = new Circle(30);
        greenLight.setFill(Color.GREEN);
        greenLight.setStroke(Color.BLACK);
        greenLight.setStrokeWidth(2);
        greenLight.setOpacity(0.3);

        Text stopText = new Text("Stop");
        stopText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        stopText.setFill(Color.DARKGRAY);

        VBox trafficLightBox = new VBox(5);
        trafficLightBox.setAlignment(Pos.CENTER);
        trafficLightBox.setPadding(new javafx.geometry.Insets(20));
        trafficLightBox.getChildren().addAll(redLight, yellowLight, greenLight, stopText);

        Scene scene = new Scene(trafficLightBox, 400, 400);
        scene.setFill(Color.DARKGRAY);

        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
