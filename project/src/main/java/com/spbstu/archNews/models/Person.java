package com.spbstu.archNews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PersonType typeOfUser;


    public Person(String login, String name, String email, String phoneNumber, String password, PersonType typeOfUser) {
        this.login = login;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.typeOfUser = typeOfUser;
    }

    public boolean isAuth() {
        return false;
    }

    public boolean logOut() {
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, login='%s', name='%s', email='%s']",
                id, login, name, email);
    }
}
