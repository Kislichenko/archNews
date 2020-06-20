package com.spbstu.archNews.repositories;

import com.spbstu.archNews.models.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RequestDAO {

    public Request findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Request.class, id);
    }


    public void save(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(request);
        tx1.commit();
        session.close();
    }

    public void update(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(request);
        tx1.commit();
        session.close();
    }

    public void delete(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(request);
        tx1.commit();
        session.close();
    }
}
