package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {
    private TextField inputField;
    private TextArea logArea;

    @Override
    public void start(Stage primaryStage){
        inputField = new TextField();
        inputField.setPromptText("Tap here to log keyboard event...");

        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefRowCount(5);
        logArea.setWrapText(true);

        inputField.setOnKeyPressed(keyEvent -> {
            String line = String.format("PRESSED | Code: %s", keyEvent.getCode(), keyEvent.isShiftDown(), keyEvent.isControlDown());
            logArea.appendText(line + "\n");
        });
        inputField.setOnKeyReleased(keyEvent -> {
            String line = String.format("RELEASED | Code: %s", keyEvent.getCode());
            logArea.appendText(line + "\n");
        });
        inputField.setOnKeyTyped(keyEvent -> {
            String line = String.format("TYPED | Code: %s", keyEvent.getCharacter());
            logArea.appendText(line + "\n");
        });

        Button clearButton = new Button("Clear Log");
        clearButton.setOnAction(actionEvent -> logArea.clear());

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.getChildren().addAll(inputField, logArea, clearButton);

        Scene scene = new Scene(vBox, 420, 320);
        primaryStage.setTitle("Key Event Logger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
