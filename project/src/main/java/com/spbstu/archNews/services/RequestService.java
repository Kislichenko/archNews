package com.spbstu.archNews.services;

import com.spbstu.archNews.models.Request;
import com.spbstu.archNews.repositories.RequestDAO;

import java.util.List;

public class RequestService {

    private RequestDAO requestsDao = new RequestDAO();

    public RequestService() {
    }

    public Request findRequest(Long id) {
        return requestsDao.findById(id);
    }

    public void saveRequest(Request request) {
        requestsDao.save(request);
    }

    public void deleteRequest(Request request) {
        requestsDao.delete(request);
    }

    public void updateRequest(Request request) {
        requestsDao.update(request);
    }

    public List<Request> getAll() {
        return requestsDao.getRequests();
    }


}
