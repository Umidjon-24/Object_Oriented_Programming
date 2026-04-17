package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginView {

    private Scene scene;

    public LoginView(Main app, UserService service) {

        Label title = new Label("Login");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Label message = new Label();

        Button loginBtn = new Button("Log In");
        Button registerBtn = new Button("Register");

        loginBtn.setOnAction(e -> {
            if (service.checkUser(username.getText(), password.getText())) {
                app.showWelcome(username.getText());
            } else {
                message.setText("Wrong username or password");
            }
        });

        registerBtn.setOnAction(e -> app.showRegister());

        VBox layout = new VBox(10, title, username, password, loginBtn, registerBtn, message);
        layout.setStyle("-fx-padding:20;");

        scene = new Scene(layout, 300, 250);
    }

    public Scene getScene() {
        return scene;
    }
}
