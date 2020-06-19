package com.spbstu.archNews;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginSignInButton;

    @FXML
    void initialize() {
        loginSignInButton.setOnAction(event -> {
            System.out.println("Вы нажали на кнопку войти!");
        });

    }
}

