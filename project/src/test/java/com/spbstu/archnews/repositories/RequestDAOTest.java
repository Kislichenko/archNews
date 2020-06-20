package com.spbstu.archnews.repositories;

import com.spbstu.archNews.models.Request;
import com.spbstu.archNews.repositories.RequestDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestDAOTest {

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

    private Session getNewSession() {
        return sessionFactory.openSession();
    }


    @Test
    public void delete() {
        RequestDAO requestDAO = new RequestDAO();
        Request request = new Request();
        request.setStatus("статус");
        requestDAO.save(request);
        assertEquals(1, requestDAO.getRequests().size());
        requestDAO.delete(request);
        assertEquals(0, requestDAO.getRequests().size());
    }

    @Test
    public void getRequests() {
        RequestDAO requestDAO = new RequestDAO();
        assertEquals(0, requestDAO.getRequests().size());
    }

    @Test
    public void getRequestsAfterSave() {
        RequestDAO requestDAO = new RequestDAO();
        Request request = new Request();
        request.setStatus("статус");
        requestDAO.save(request);
        assertEquals(1, requestDAO.getRequests().size());
        assertEquals("статус", requestDAO.getRequests().get(0).getStatus());
    }

    @Test
    public void findById() {

    }

    @Test
    public void save() {
        RequestDAO requestDAO = new RequestDAO();
        Request request = new Request();
        request.setStatus("статус2");
        requestDAO.save(request);
        assertEquals(2, requestDAO.getRequests().size());

    }

    @Test
    public void update() {
        RequestDAO requestDAO = new RequestDAO();
        Request request = new Request();
        request.setStatus("статус3");
        requestDAO.save(request);
        List<Request> requests = requestDAO.getRequests();
        Long id = 0l;

        for(int i=0;i<requests.size();i++){
            if(requests.get(i).getStatus().equals("статус3")){
                Request tmp = requests.get(i);
                tmp.setStatus("статус4");
                requestDAO.update(tmp);
                id = tmp.getId();
            }
        }

        Request tmpReq = requestDAO.findById(id);

        assertEquals("статус4", tmpReq.getStatus());
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
