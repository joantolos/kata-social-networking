package com.joantolos.kata.social.networking.ui;

public enum Magnitude {

    DAY ("days", "day"),
    HOUR ("hours", "hour"),
    MINUTE ("minutes", "minute"),
    SECOND ("seconds", "second");

    private String plural;
    private String singular;

    Magnitude(String plural, String singular){
        this.plural = plural;
        this.singular = singular;
    }

    public String getPlural() {
        return plural;
    }

    public String getSingular() {
        return singular;
    }
}
