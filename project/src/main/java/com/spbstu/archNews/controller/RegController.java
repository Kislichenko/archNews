package com.spbstu.archNews.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.spbstu.archNews.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authBut;

    @FXML
    private Button loginSignInButton;

    @FXML
    void initialize() {
        authBut.setOnAction(event -> {
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/auth.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

    }
}
