package com.spbstu.archNews;


import com.spbstu.archNews.models.Person;
import com.spbstu.archNews.services.PersonService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
//        PersonService userService = new PersonService();
//        Person user = new Person("login1", "Bogdan", "bogdan@archnews.ru");
//        userService.saveUser(user);
//        userService.updateUser(user);

    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/advertiser.fxml"));
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
