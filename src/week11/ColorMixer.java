package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorMixer extends Application {
    private void displayColorPanel(Stage stage, double r, double g, double b, String title) {
        Rectangle colorPreview = new Rectangle(200, 200);
        colorPreview.setFill(new Color(r, g, b, 1));

        Text rLabel = new Text(String.format("R: %.2f", r));
        rLabel.setFont(Font.font("Arial", 14));

        Text gLabel = new Text(String.format("G: %.2f", g));
        gLabel.setFont(Font.font("Arial", 14));

        Text bLabel = new Text(String.format("B: %.2f", b));
        bLabel.setFont(Font.font("Arial", 14));

        int hexR = (int) (r * 255);
        int hexG = (int) (g * 255);
        int hexB = (int) (b * 255);
        String hexCode = String.format("#%02X%02X%02X", hexR, hexG, hexB);

        Text hexLabel = new Text(hexCode);
        hexLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        VBox colorBox = new VBox(8);
        colorBox.setPadding(new javafx.geometry.Insets(20));
        colorBox.setAlignment(Pos.CENTER);
        colorBox.getChildren().addAll(colorPreview, rLabel, gLabel, bLabel, hexLabel);

        Scene scene = new Scene(colorBox, 400, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {
//        displayColorPanel(primaryStage, 0.53, 0.81, 1.0, "Color Mixer - Sky Blue");
        displayColorPanel(primaryStage, 1.0, 1.0, 0, "Color Mixer - Yellow");
//        displayColorPanel(primaryStage, 1.0, 0, 1.0, "Color Mixer - Purple");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

