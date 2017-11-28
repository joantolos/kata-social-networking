package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.entity.TimeLapse;

import java.sql.Timestamp;

public class Clock {

    public TimeLapse getTimeLapse(Timestamp date) {
        Long millisecondsIncrement = date.getTime() - new Timestamp(System.currentTimeMillis()).getTime();

        return new TimeLapse(
                (millisecondsIncrement / (24 * 60 * 60 * 1000)) * -1,
                (millisecondsIncrement / (60 * 60 * 1000)) * -1,
                (millisecondsIncrement / (60 * 1000)) * -1,
                (millisecondsIncrement / 1000) * -1);
    }
}
