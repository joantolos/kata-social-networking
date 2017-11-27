package com.joantolos.kata.social.networking.entity;

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

    public String getTimeLapse() {
        Long millisecondsIncrement = this.date.getTime() - new Timestamp(System.currentTimeMillis()).getTime();
        Long secondsIncrement = (millisecondsIncrement / 1000) * -1;
        Long minutesIncrement = (millisecondsIncrement / (60 * 1000)) * -1;
        Long hoursIncrement = (millisecondsIncrement / (60 * 60 * 1000)) * -1;
        Long daysIncrement = (millisecondsIncrement / (24 * 60 * 60 * 1000)) * -1;

        if(daysIncrement!=0) {
            return daysIncrement + " days ago";
        } else if(hoursIncrement!=0) {
            return hoursIncrement + " hours ago";
        } else if(minutesIncrement!=0) {
            return minutesIncrement + " minutes ago";
        }

        return secondsIncrement + " seconds ago";
    }
}
