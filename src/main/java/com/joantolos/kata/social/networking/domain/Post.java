package com.joantolos.kata.social.networking.domain;

import java.sql.Timestamp;

public class Post {

    private User user;
    private String message;
    private Timestamp date;

    public Post(User user, String message) {
        this.user = user;
        this.message = message;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getDate() {
        return date;
    }
}
