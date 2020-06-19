package com.spbstu.archNews.models;

import lombok.Data;

@Data
public class Request {
    private String name;
    private String status;
    private String dateOfCreation;
    private Integer cost;

}
