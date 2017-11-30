package com.joantolos.kata.social.networking.time;

import com.joantolos.kata.social.networking.domain.TimeLapse;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;

public class ClockTest {

    @Test
    public void timeLapseShouldIncludeDays(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -2);
        Timestamp oneYearAgo = new Timestamp(cal.getTimeInMillis());

        Clock clock = new Clock();
        TimeLapse timeLapse = clock.getTimeLapse(oneYearAgo);
        Assert.assertEquals("days", timeLapse.getMagnitude());
        Assert.assertNotNull(timeLapse.getTime());
    }

    @Test
    public void timeLapseShouldIncludeHours(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -2);
        Timestamp oneYearAgo = new Timestamp(cal.getTimeInMillis());

        Clock clock = new Clock();
        TimeLapse timeLapse = clock.getTimeLapse(oneYearAgo);
        Assert.assertEquals("hours", timeLapse.getMagnitude());
        Assert.assertNotNull(timeLapse.getTime());
    }

    @Test
    public void timeLapseShouldIncludeMinutes(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -2);
        Timestamp oneYearAgo = new Timestamp(cal.getTimeInMillis());

        Clock clock = new Clock();
        TimeLapse timeLapse = clock.getTimeLapse(oneYearAgo);
        Assert.assertEquals("minutes", timeLapse.getMagnitude());
        Assert.assertNotNull(timeLapse.getTime());
    }

    @Test
    public void timeLapseShouldIncludeSeconds(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, -2);
        Timestamp oneYearAgo = new Timestamp(cal.getTimeInMillis());

        Clock clock = new Clock();
        TimeLapse timeLapse = clock.getTimeLapse(oneYearAgo);
        Assert.assertEquals("seconds", timeLapse.getMagnitude());
        Assert.assertNotNull(timeLapse.getTime());
    }
}
