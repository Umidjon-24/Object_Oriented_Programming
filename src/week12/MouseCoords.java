package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseCoords extends Application {
    private Label coordsLabel;

    @Override
    public void start(Stage primaryStage){
        coordsLabel = new Label("Move the mouse over the pane");
        coordsLabel.setStyle("-fx-font-size: 14;");

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: lightblue;");
        stackPane.setPrefSize(400, 300);
        stackPane.setOnMouseMoved(event -> updateCoords(event));
        stackPane.setOnMouseClicked(event -> changeBackground());
        stackPane.setOnMouseExited(event -> {
            coordsLabel.setText("Move mouse over the pane");
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(stackPane);
        borderPane.setBottom(coordsLabel);
        BorderPane.setAlignment(coordsLabel, Pos.CENTER);

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mouse Coordinates");
        primaryStage.show();
    }
    private void updateCoords(MouseEvent event){
        double x = event.getX();
        double y = event.getY();
        coordsLabel.setText(String.format("X: %.1f   Y: %.1f", x, y));
    }
    private void changeBackground(){
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        StackPane stackPane = (StackPane) ((BorderPane)((Scene) coordsLabel.getScene()).getRoot()).getCenter();
        String colorStyle = String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b);
        stackPane.setStyle(colorStyle);
    }
}
