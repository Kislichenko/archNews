package com.spbstu.archnews.repositories;

import com.spbstu.archNews.models.Person;
import com.spbstu.archNews.models.PersonType;
import com.spbstu.archNews.repositories.PersonDAO;
import com.spbstu.archNews.services.PersonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusinessLogicTest {

    private SessionFactory sessionFactory;
    private static Session hibernateSession;

    @Before
    public void setUp() {
        sessionFactory = createSessionFactory();
        hibernateSession = sessionFactory.openSession();
    }

    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void authTest(){
        PersonDAO usersDao = new PersonDAO();
        Person person = new Person();
        person.setLogin("Login7");
        person.setName("Log7");
        person.setPassword("Login7");
        person.setPhoneNumber("+7932");
        person.setTypeOfUser(PersonType.USER);
        person.setEmail("fff@email.ru");
        usersDao.save(person);

        PersonService personService = new PersonService();
        assertEquals(false, personService.auth("Login7", "Login6"));
        assertEquals(true, personService.auth("Login7", "Login7"));
    }

    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration.buildSessionFactory();
    }
}
