package com.spbstu.archNews.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.spbstu.archNews.Main;
import com.spbstu.archNews.services.PersonService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthController {
    PersonService personService = new PersonService();

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
            System.out.println(loginField.getText());
            if(personService.auth(loginField.getText(), passwordField.getText())){
                System.out.println("AUTH");
            }
            System.out.println("Вы нажали на кнопку войти!");

            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

    }
}

