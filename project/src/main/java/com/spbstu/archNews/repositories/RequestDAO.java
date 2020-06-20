package com.spbstu.archNews.repositories;

import com.spbstu.archNews.models.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RequestDAO {

    public List<Request> getRequests(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        List <Request> reuquests = loadAllData(Request.class, session);
        tx1.commit();
        session.close();
        return reuquests;

    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public Request findById(Long id) {
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
