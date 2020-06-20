package com.spbstu.archNews.services;

import com.spbstu.archNews.models.Person;
import com.spbstu.archNews.repositories.PersonDAO;

public class PersonService {
    private PersonDAO usersDao = new PersonDAO();

    public PersonService() {
    }

    public Person findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(Person user) {
        usersDao.save(user);
    }

    public void deleteUser(Person user) {
        usersDao.delete(user);
    }

    public void updateUser(Person user) {
        usersDao.update(user);
    }

    public boolean auth(String login, String password) {
        Person person = usersDao.findByLogin(login);
        if (person.getPassword().equals(password)) {
            return true;
        }
        return false;


    }


}
