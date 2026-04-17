package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class WelcomeView {

    private Scene scene;

    public WelcomeView(Main app, String username) {

        Label welcome = new Label("Welcome, " + username + "!");
        Label info = new Label("You are logged in.");

        Button logoutBtn = new Button("Logout");

        logoutBtn.setOnAction(e -> app.showLogin());

        VBox layout = new VBox(15, welcome, info, logoutBtn);
        layout.setStyle("-fx-padding:20;");

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
