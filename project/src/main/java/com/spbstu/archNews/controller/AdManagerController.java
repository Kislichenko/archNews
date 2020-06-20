package com.spbstu.archNews.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.spbstu.archNews.Main;
import com.spbstu.archNews.models.Request;
import com.spbstu.archNews.services.RequestService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdManagerController {

    ObservableList list = FXCollections.observableArrayList();
    RequestService requestService = new RequestService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Request> advertTable;

    @FXML
    private TableColumn<Request, String> colName;

    @FXML
    private TableColumn<Request, String> colStatus;

    @FXML
    private TableColumn<Request, String> colDateOfCreation;

    @FXML
    private TableColumn<Request, Number> colCost;

    @FXML
    private TableColumn<Request, String> colDesc;

    @FXML
    private TableColumn<Request, String> colChange;

    @FXML
    private Button logOutBut;

    @FXML
    void initialize() {
        list.removeAll(list);
        List<Request> tmp = requestService.getAll();
        List<Request> requests = new ArrayList<>();

        for(int i=0;i<tmp.size();i++){
            if(tmp.get(i).getStatus().equals("Ожидает проверки менеджером")){
                requests.add(tmp.get(i));
            }
        }

        if(requests != null && requests.size()!=0) {
            list.addAll(requests);
            colName.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                    -> new SimpleStringProperty(param.getValue().getId().toString()));

            colStatus.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                    -> new SimpleStringProperty(param.getValue().getLegalData()));

            colDateOfCreation.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                    -> new SimpleStringProperty(param.getValue().getOpenAdDate()));


            colCost.setCellValueFactory((TableColumn.CellDataFeatures<Request, Number> param)
                    -> new SimpleIntegerProperty(param.getValue().getCost()));

            colDesc.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                    -> new SimpleStringProperty(param.getValue().getStatus()));



            colChange.setCellFactory(col -> {
                Button editButton = new Button("Подробнее");
                TableCell<Request, String> cell = new TableCell<Request, String>() {
                    @Override
                    public void updateItem(String request, boolean empty) {
                        super.updateItem(request, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(editButton);
                        }
                    }
                };

                editButton.setOnAction(event -> {
                    Main.setRequest(new Long(cell.getTableRow().getItem().toString().substring(
                            cell.getTableRow().getItem().toString().indexOf("id=")+3,
                            cell.getTableRow().getItem().toString().indexOf(",", cell.getTableRow().getItem().toString().indexOf("id=")+1)
                    )));

                    Parent newScene = null;
                    try {
                        newScene = FXMLLoader.load(getClass().getResource("/advertReq.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    Main.getStage().setScene(new Scene(newScene));
                });

                return cell ;
            });
        }


        logOutBut.setOnAction(event ->{
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/auth.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.getStage().setScene(new Scene(newScene));
        });

        advertTable.setEditable(true);
        advertTable.setItems(list);
    }
}


