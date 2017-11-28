package com.joantolos.kata.social.networking.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

public class ClockTest {

    private TimeLapse lapse;

    @Before
    public void setUp(){
        Clock clock = new Clock();
        Timestamp postDate = new Timestamp(System.currentTimeMillis());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assert.fail();
        }

        this.lapse = clock.getTimeLapse(postDate);
    }

    @Test
    public void shouldCalculateTimeLapse() {
        Assert.assertNotNull(lapse);
    }

    @Test
    public void timeLapseShouldIncludeDays() {
        Assert.assertNotNull(lapse.getDays());
    }

    @Test
    public void timeLapseShouldIncludeHours() {
        Assert.assertNotNull(lapse.getHours());
    }

    @Test
    public void timeLapseShouldIncludeMinutes() {
        Assert.assertNotNull(lapse.getMinutes());
    }

    @Test
    public void timeLapseShouldIncludeSeconds() {
        Assert.assertNotNull(lapse.getSeconds());
    }
}
