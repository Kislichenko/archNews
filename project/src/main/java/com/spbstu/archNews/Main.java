package com.spbstu.archNews;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class Main extends Application {

    private static Stage guiStage;
    private static Long requestInd = -1l;

    @Getter
    @Setter
    private static String name = "";

    public static Stage getStage() {
        return guiStage;
    }

    public static Long getRequest() {
        return requestInd;
    }

    public static void setRequest(Long req) {
        requestInd = req;
    }

    public static void main(String[] args) {
        launch(args);
//        RequestService requestService = new RequestService();
//        Request request = new Request();
//        request.setType("GGGGG");
//        requestService.saveRequest(request);
//        PersonService userService = new PersonService();
//        Person user = new Person("login1", "Bogdan", "bogdan@archnews.ru", "", "login1");
//        userService.saveUser(user);
//        userService.updateUser(user);

    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/auth.fxml"));
        //primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root));
        guiStage = primaryStage;
        primaryStage.show();
    }
}
