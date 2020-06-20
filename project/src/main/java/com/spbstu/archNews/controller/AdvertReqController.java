package com.spbstu.archNews.controller;

import com.spbstu.archNews.Main;
import com.spbstu.archNews.models.AdBlockType;
import com.spbstu.archNews.models.Request;
import com.spbstu.archNews.services.RequestService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

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
    private TextField costTextField;

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
    private Label inputLabel;

    @FXML
    private Button pay;

    @FXML
    private Button updateBut;

    private RequestService requestService = new RequestService();

    @FXML
    void initialize() {

        if (Main.getRequest() != -1l) {
            Request request = requestService.findRequest(Main.getRequest());
            typeAdBlock.setValue(request.getAdBlockType());
            adType.setText(request.getType());

            adDuration.setText(request.getAdDuration().toString());
            adStart.setText(request.getStartDate());
            legalData.setText(request.getLegalData());
            openAdDate.setText(request.getOpenAdDate());
            description.setText(request.getDescription());
            cost.setText(request.getCost().toString());
            statusReq.setText(request.getStatus());

        }
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

        updateBut.setOnAction(event -> {
            Request request = new Request();
            request.setId(Main.getRequest());
            request.setAdBlockType(typeAdBlock.getValue());
            request.setType(adType.getText());
            request.setAdDuration(new Integer(adDuration.getText()));
            request.setStartDate(adStart.getText());
            request.setLegalData(legalData.getText());
            request.setOpenAdDate(openAdDate.getText());
            request.setDescription(description.getText());

            if (!Main.getName().equals("login1")) {
                request.setCost(new Integer(costTextField.getText()));
                request.setStatus("Ожидает оплаты");
            } else {
                request.setCost(-1);
                request.setStatus("Ожидает проверки менеджером");
            }

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());

            request.setOpenAdDate(timeStamp);
            requestService.updateRequest(request);


            Parent newScene = null;
            try {
                if (!Main.getName().equals("login1")) {
                    newScene = FXMLLoader.load(getClass().getResource("/admanager.fxml"));
                } else {
                    newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.setRequest(-1l);
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
            request.setDescription(description.getText());
            request.setCost(-1);
            request.setStatus("Ожидает проверки менеджером");

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());

            request.setOpenAdDate(timeStamp);
            requestService.saveRequest(request);


            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.setRequest(-1l);
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

        if (!Main.getName().equals("login1")) {
            sendReq.setVisible(false);
            pay.setVisible(false);
            cost.setVisible(false);
            updateBut.setText("Подтвердить заявку");
            inputLabel.setText("Вы вошли как admanager2");
            costTextField.setVisible(true);
        } else {
            sendReq.setVisible(true);
            pay.setVisible(true);
            cost.setVisible(true);
            updateBut.setText("Обновить заявку");
            inputLabel.setText("Вы вошли как advertiser1");
            costTextField.setVisible(false);
        }

    }
}

