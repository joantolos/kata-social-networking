package com.joantolos.kata.social.networking.core;

public class TimeLapse {

    private Long days;
    private Long hours;
    private Long minutes;
    private Long seconds;

    public TimeLapse(Long days, Long hours, Long minutes, Long seconds) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Long getDays() {
        return days;
    }

    public Long getHours() {
        return hours;
    }

    public Long getMinutes() {
        return minutes;
    }

    public Long getSeconds() {
        return seconds;
    }
}
