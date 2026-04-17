package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegisterView {

    private Scene scene;

    public RegisterView(Main app, UserService service) {

        Label title = new Label("Register");

        TextField username = new TextField();
        username.setPromptText("Username");

        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        PasswordField confirm = new PasswordField();
        confirm.setPromptText("Confirm Password");

        Label message = new Label();

        Button registerBtn = new Button("Register");
        Button backBtn = new Button("Back");

        registerBtn.setOnAction(e -> {
            if (username.getText().isEmpty() ||
                    email.getText().isEmpty() ||
                    password.getText().isEmpty()) {

                message.setText("Fill all fields");
                return;
            }

            if (!password.getText().equals(confirm.getText())) {
                message.setText("Passwords don't match");
                return;
            }

            if (service.userExists(username.getText(), email.getText())) {
                message.setText("User exists");
                return;
            }

            service.saveUser(username.getText(), password.getText(), email.getText());
            message.setText("Registered!");
        });

        backBtn.setOnAction(e -> app.showLogin());

        VBox layout = new VBox(10, title, username, email, password, confirm, registerBtn, backBtn, message);
        layout.setStyle("-fx-padding:20;");

        scene = new Scene(layout, 300, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
