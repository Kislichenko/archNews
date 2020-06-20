package com.spbstu.archNews.repositories;

import com.spbstu.archNews.models.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersonDAO {

    public Person findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class, id);
    }

    public Person findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("from Person where login =:login ")
                .setParameter("login", login);

        Person person = (Person) query.uniqueResult();


        tx1.commit();
        session.close();
        return person;

    }

    public void save(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }

}
