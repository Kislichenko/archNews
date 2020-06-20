package com.spbstu.archNews.models;

public enum AdBlockType {
    SIMPLE_BLOCK("simple block"),
    HEADER_BLOCK("header block"),
    INNER_BLOCK("inner block"),
    END_BLOCK("end block");

    private String title;

    AdBlockType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
