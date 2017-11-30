package com.joantolos.kata.social.networking.domain;

public class TimeLapse {

    private Long time;
    private String magnitude;

    public TimeLapse(Long days, Long hours, Long minutes, Long seconds) {
        if(days > 0){
            this.time = (days);
            this.magnitude = this.time > 1L ? "days" : "day";
        } else if(hours > 0){
            this.time = hours;
            this.magnitude = this.time > 1L ? "hours" : "hour";
        } else if(minutes > 0){
            this.time = minutes;
            this.magnitude = this.time > 1L ? "minutes" : "minute";
        } else if(seconds > 0){
            this.time = seconds;
            this.magnitude = this.time > 1L ? "seconds" : "second";
        }
    }

    public Long getTime() {
        return time;
    }

    public String getMagnitude() {
        return magnitude;
    }
}
