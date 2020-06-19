package com.spbstu.archNews;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.spbstu.archNews.models.Request;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class AdvertiserController {
    ObservableList list = FXCollections.observableArrayList();

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
    void initialize() {

        getData();
    }

    void getData(){


        list.removeAll(list);
        for(int i=0;i<30;i++) {

            Request request = new Request();
            request.setCost(100);
            request.setDateOfCreation("Dfg");
            request.setName("name"+i);
            request.setStatus("closed");
            list.add(request);
        }

        //colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                -> new SimpleStringProperty(param.getValue().getName()));

        colStatus.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                -> new SimpleStringProperty(param.getValue().getStatus()));

        colDateOfCreation.setCellValueFactory((TableColumn.CellDataFeatures<Request, String> param)
                -> new SimpleStringProperty(param.getValue().getDateOfCreation()));

        colCost.setCellValueFactory((TableColumn.CellDataFeatures<Request, Number> param)
                -> new SimpleIntegerProperty(param.getValue().getCost()));

        //colChange.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        setBtnEditCellFactory();

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
//                        btn.setOnAction(event -> {
//                            Request col = getTableView().getItems().get(getIndex());
//                            Lesson lessonOld = new Lesson(lesson);
//                            try {
//                                Main.clientOnLessonView(login, name, status, lessonOld, col);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        });
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
