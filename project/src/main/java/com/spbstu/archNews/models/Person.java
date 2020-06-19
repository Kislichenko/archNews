package com.spbstu.archNews.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    private String phoneNumber;
    private String password;

    public Person(String login, String name, String email){
        this.login = login;
        this.email = email;
        this.name = name;
    }
    public void auth(){

    }

    public boolean isAuth(){
        return false;
    }

    public boolean logOut(){
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, login='%s', name='%s', email='%s']",
                id, login, name, email);
    }
}
