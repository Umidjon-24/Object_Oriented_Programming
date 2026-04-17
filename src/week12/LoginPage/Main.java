package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;
    private UserService userService = new UserService();

    @Override
    public void start(Stage stage) {
        window = stage;
        showLogin();
        window.setTitle("App");
        window.show();
    }

    public void showLogin() {
        LoginView view = new LoginView(this, userService);
        window.setScene(view.getScene());
    }

    public void showRegister() {
        RegisterView view = new RegisterView(this, userService);
        window.setScene(view.getScene());
    }

    public void showWelcome(String username) {
        WelcomeView view = new WelcomeView(this, username);
        window.setScene(view.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
