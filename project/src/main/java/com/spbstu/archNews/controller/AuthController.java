package com.spbstu.archNews.controller;

import com.spbstu.archNews.Main;
import com.spbstu.archNews.services.PersonService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Button regBut;

    @FXML
    void initialize() {
        loginSignInButton.setOnAction(event -> {
            System.out.println(loginField.getText());
            if (loginField.getText().equals("login1") && personService.auth(loginField.getText(), passwordField.getText())) {
                System.out.println("AUTH");
                Main.setName("login1");
                Parent newScene = null;
                try {
                    newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Main.getStage().setScene(new Scene(newScene));
            } else {
                Main.setName("");
                Parent newScene = null;
                try {
                    newScene = FXMLLoader.load(getClass().getResource("/admanager.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Main.getStage().setScene(new Scene(newScene));
            }


        });

        regBut.setOnAction(event -> {
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/registration.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

    }
}

