package com.spbstu.archNews;


import com.spbstu.archNews.models.Person;
import com.spbstu.archNews.services.PersonService;

public class Main {
    public static void main(String[] args) {
        PersonService userService = new PersonService();
        Person user = new Person("login1", "Bogdan", "bogdan@archnews.ru");
        userService.saveUser(user);
        userService.updateUser(user);

    }
}
