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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class AdvertiserController {
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
    private TableColumn<Request, String> colChange1;

    @FXML
    private Button logOutBut;

    @FXML
    private Button createNew;


    @FXML
    void initialize() {

        getData();
    }

    void getData(){


        list.removeAll(list);
        List<Request> requests = requestService.getAll();

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
                    System.out.println("GGGG: "+new Long(cell.getTableRow().getItem().toString().substring(
                            cell.getTableRow().getItem().toString().indexOf("id=")+3,
                            cell.getTableRow().getItem().toString().indexOf(",", cell.getTableRow().getItem().toString().indexOf("id=")+1)
                    )));
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
            //setBtnEditCellFactory();
        }


        colChange1.setCellFactory(col -> {
            Button editButton = new Button("Оплатить");
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

                Request request = requestService.findRequest(Main.getRequest());
                request.setStatus("Оплачено");
                requestService.updateRequest(request);

                Parent newScene = null;
                try {
                    newScene = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Main.getStage().setScene(new Scene(newScene));
            });

            return cell ;
        });
        //setBtnEditCellFactory();


        createNew.setOnAction(event -> {
            Parent newScene = null;
            try {
                newScene = FXMLLoader.load(getClass().getResource("/advertReq.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.setRequest(-1l);
            Main.getStage().setScene(new Scene(newScene));
        });
        //colChange.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));


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
        //AdvertTable.getColumns().get(0)..addAll(list);
    }

    private void setBtnEditCellFactory() {
        Callback<TableColumn<Request, String>, TableCell<Request, String>> btnDisplayCellFactory
                = new Callback<TableColumn<Request, String>, TableCell<Request, String>>() {
            @Override
            public TableCell<Request, String> call(TableColumn<Request, String> param) {

                final TableCell<Request, String> cell = new TableCell<Request, String>() {


                    final Button btn = new Button("Подробнее");
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        btn.getStyleClass().add("btn-default");
                        btn.setOnAction(event -> {
                            Parent newScene = null;
                            try {
                                newScene = FXMLLoader.load(getClass().getResource("/advertReq.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Main.getStage().setScene(new Scene(newScene));
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                };
                return cell;
            }
        };
        colChange.setCellFactory(btnDisplayCellFactory);
    }
}
