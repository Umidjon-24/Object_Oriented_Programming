package org.example;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountdownTimer extends Application {
    private int remainingSeconds = 0;
    private Timeline timeline;
    private Label timeLabel = new Label("00:00");
    private Label statusLabel = new Label();
    private TextField inputField = new TextField();
    private FadeTransition fade;

    @Override
    public void start(Stage stage) {
        timeLabel.setStyle(
                "-fx-font-size: 52px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: monospace;"
        );
        inputField.setPromptText("Enter minutes");

        Button startBtn = new Button("Start");
        Button pauseBtn = new Button("Pause / Resume");
        Button resetBtn = new Button("Reset");
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (remainingSeconds > 0) {
                remainingSeconds--;
                updateDisplay();
            } else {
                timeline.stop();
                startFadeEffect();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        startBtn.setOnAction(e -> {
            String text = inputField.getText().trim();
            try {
                int minutes = Integer.parseInt(text);
                if (minutes <= 0) throw new NumberFormatException();
                remainingSeconds = minutes * 60;
                updateDisplay();
                stopFadeEffect();
                timeLabel.setStyle(
                        "-fx-font-size: 52px;" +
                                "-fx-font-weight: bold;" +
                                "-fx-font-family: monospace;" +
                                "-fx-text-fill: black;"
                );
                timeline.playFromStart();
                statusLabel.setText("");
            } catch (Exception ex) {
                statusLabel.setText("Enter a valid number (> 0)");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        });
        pauseBtn.setOnAction(e -> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.pause();
            } else if (timeline.getStatus() == Animation.Status.PAUSED) {
                timeline.play();
            }
        });
        resetBtn.setOnAction(e -> {
            timeline.stop();
            remainingSeconds = 0;
            updateDisplay();
            stopFadeEffect();
            timeLabel.setStyle(
                    "-fx-font-size: 52px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-font-family: monospace;" +
                            "-fx-text-fill: black;"
            );
        });
        VBox root = new VBox(16, inputField, startBtn, pauseBtn, resetBtn, timeLabel, statusLabel);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 340, 260);
        stage.setTitle("Countdown Timer");
        stage.setScene(scene);
        stage.show();
    }
    private void updateDisplay() {
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
    private void startFadeEffect() {
        timeLabel.setStyle(
                "-fx-font-size: 52px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: monospace;" +
                        "-fx-text-fill: red;"
        );

        fade = new FadeTransition(Duration.seconds(0.5), timeLabel);
        fade.setFromValue(1.0);
        fade.setToValue(0.1);
        fade.setAutoReverse(true);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.play();
    }

    private void stopFadeEffect() {
        if (fade != null) {
            fade.stop();
            timeLabel.setOpacity(1.0);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
