package com.spbstu.archNews.models;

public enum PersonType {
    ADVERT_MANAGER("advert manager"),
    INFO_MANAGER("info manager"),
    REPORTER("reporter"),
    USER("user");

    private String title;

    PersonType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "PersonType{" +
                "title='" + title + '\'' +
                '}';
    }
}
