package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.TimeLapse;

import java.sql.Timestamp;

public class Clock {

    public TimeLapse getTimeLapse(Timestamp date) {
        Long millisecondsIncrement = date.getTime() - new Timestamp(System.currentTimeMillis()).getTime();

        return new TimeLapse(
                getIncrement(millisecondsIncrement, 24 * 60 * 60 * 1000),
                getIncrement(millisecondsIncrement, 60 * 60 * 1000),
                getIncrement(millisecondsIncrement, 60 * 1000),
                getIncrement(millisecondsIncrement, 1000));
    }

    private long getIncrement(Long millisecondsIncrement, Integer factor) {
        return (millisecondsIncrement / factor) * -1;
    }
}
