package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.core.TimeLapse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserInterfaceTest {

    private UserInterface ui;

    @Before
    public void setUp(){
        this.ui = new UserInterface();
    }

    @Test
    public void shouldPrintSecondsTimeLapse(){
        TimeLapse secondsLapse = new TimeLapse(0L, 0L, 0L, 15L);
        String secondsPrint = this.ui.createTimeLapse(secondsLapse);
        Assert.assertEquals("(15 seconds ago)", secondsPrint);
    }

    @Test
    public void shouldPrintMinutesTimeLapse(){
        TimeLapse minutesLapse = new TimeLapse(0L, 0L, 15L, 0L);
        String minutesPrint = this.ui.createTimeLapse(minutesLapse);
        Assert.assertEquals("(15 minutes ago)", minutesPrint);
    }

    @Test
    public void shouldPrintHoursTimeLapse(){
        TimeLapse hoursLapse = new TimeLapse(0L, 1L, 0L, 0L);
        String hoursPrint = this.ui.createTimeLapse(hoursLapse);
        Assert.assertEquals("(1 hours ago)", hoursPrint);
    }

    @Test
    public void shouldPrintDaysTimeLapse(){
        TimeLapse daysLapse = new TimeLapse(1L, 0L, 0L, 0L);
        String daysPrint = this.ui.createTimeLapse(daysLapse);
        Assert.assertEquals("(1 days ago)", daysPrint);
    }
}
