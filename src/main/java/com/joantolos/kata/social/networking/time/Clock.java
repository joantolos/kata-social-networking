package com.joantolos.kata.social.networking.time;

import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.ui.Magnitude;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Clock {

    DAY (Magnitude.DAY, (24L * 60L * 60L * 1000L) * -1),
    HOUR (Magnitude.HOUR, (60L * 60L * 1000L) * -1),
    MINUTE (Magnitude.MINUTE, (60L * 1000L) * -1),
    SECOND (Magnitude.SECOND, (1000L) * -1);

    private Magnitude magnitude;
    private Long factor;

    Clock(Magnitude magnitude, Long factor){
        this.magnitude = magnitude;
        this.factor = factor;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public static TimeLapse lapse(Timestamp postDate){
        Long msIncrement = (postDate.getTime() - new Timestamp(System.currentTimeMillis()).getTime());
        List<TimeLapse> timeLapses = Arrays.stream(Clock.values())
                .map(magnitude -> new TimeLapse(magnitude, msIncrement/magnitude.factor))
                .collect(Collectors.toList());
        return timeLapses.stream().filter(m -> m.getTime()>0).findFirst().orElse(new TimeLapse(Clock.SECOND, 0L));
    }
}
