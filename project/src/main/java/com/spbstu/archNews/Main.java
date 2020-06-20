package com.spbstu.archNews;


import com.spbstu.archNews.models.Person;
import com.spbstu.archNews.services.PersonService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }

    public static void main(String[] args) {
        launch(args);
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
