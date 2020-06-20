package com.spbstu.archNews.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.spbstu.archNews.Main;
import com.spbstu.archNews.models.AdBlockType;
import com.spbstu.archNews.models.Request;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodTextRun;

public class AdvertReqController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button onMain;

    @FXML
    private Button sendReq;

    @FXML
    private ComboBox<AdBlockType> typeAdBlock;

    @FXML
    private TextField adType;

    @FXML
    private TextField adDuration;

    @FXML
    private TextField adStart;

    @FXML
    private TextField legalData;

    @FXML
    private TextField description;

    @FXML
    private Label statusReq;

    @FXML
    private Label openAdDate;

    @FXML
    private Label cost;

    @FXML
    private Label closeAdDate;

    @FXML
    private Label manager;

    @FXML
    private Button pay;

    @FXML
    void initialize() {

        typeAdBlock.getItems().setAll(AdBlockType.values());
        onMain.setOnAction(event -> {
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

        logOutBtn.setOnAction(event -> {
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/auth.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

        sendReq.setOnAction(event -> {
            Request request = new Request();
            request.setAdBlockType(typeAdBlock.getValue());
            request.setType(adType.getText());
            request.setAdDuration(new Integer(adDuration.getText()));
            request.setStartDate(adStart.getText());
            request.setLegalData(legalData.getText());
            request.setOpenAdDate(openAdDate.getText());
            request.setDesciption(description.getText());

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            request.setOpenAdDate(timeStamp);



        });

    }
}

