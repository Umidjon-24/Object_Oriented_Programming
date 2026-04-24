package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class FlashcardApp extends Application {
    private ArrayList<String[]> cards = new ArrayList<>();
    private int currentIndex = 0;
    private boolean showingAnswer = false;
    private Label cardLabel = new Label();
    private Label indexLabel = new Label();
    private final String FILE_NAME = "cards.txt";

    @Override
    public void start(Stage stage) {
        if (!loadCards()) {
            VBox root = new VBox(10, new Label("No cards found. Add cards to cards.txt and restart."));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root, 480, 300);
            stage.setScene(scene);
            stage.setTitle("Flashcard App");
            stage.show();
            return;
        }
        indexLabel.setStyle("-fx-font-size: 14px;");
        cardLabel.setWrapText(true);
        cardLabel.setStyle(
                "-fx-font-size: 20px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-alignment: center; " +
                        "-fx-padding: 20; " +
                        "-fx-background-color: lightblue;"
        );
        cardLabel.setMaxWidth(400);
        cardLabel.setAlignment(Pos.CENTER);

        updateCard();
        Button flipBtn = new Button("Flip");
        Button nextBtn = new Button("Next");
        Button prevBtn = new Button("Previous");
        flipBtn.setOnAction(e -> {
            showingAnswer = !showingAnswer;
            updateCard();
        });
        nextBtn.setOnAction(e -> {
            currentIndex = (currentIndex + 1) % cards.size();
            showingAnswer = false;
            updateCard();
        });
        prevBtn.setOnAction(e -> {
            currentIndex = (currentIndex - 1 + cards.size()) % cards.size();
            showingAnswer = false;
            updateCard();
        });
        VBox root = new VBox(16, indexLabel, cardLabel, flipBtn, nextBtn, prevBtn);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 480, 300);
        stage.setTitle("Flashcard App");
        stage.setScene(scene);
        stage.show();
    }

    private boolean loadCards() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    cards.add(parts);
                }
            }
            reader.close();
            return !cards.isEmpty();
        } catch (IOException e) {
            return false;
        }
    }

    private void updateCard() {
        String[] card = cards.get(currentIndex);
        if (showingAnswer) {
            cardLabel.setText(card[1]);
            cardLabel.setStyle(
                    "-fx-font-size: 20px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-alignment: center; " +
                            "-fx-padding: 20; " +
                            "-fx-background-color: lightgreen;"
            );
        } else {
            cardLabel.setText(card[0]);
            cardLabel.setStyle(
                    "-fx-font-size: 20px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-alignment: center; " +
                            "-fx-padding: 20; " +
                            "-fx-background-color: lightblue;"
            );
        }
        indexLabel.setText("Card " + (currentIndex + 1) + " / " + cards.size());
    }
    public static void main(String[] args) {
        launch();
    }
}
