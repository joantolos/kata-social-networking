package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.entity.TimeLapse;
import com.joantolos.kata.social.networking.entity.User;
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
        String secondsPrint = this.ui.timeLapse(secondsLapse);
        Assert.assertEquals("(15 seconds ago)", secondsPrint);
    }

    @Test
    public void shouldPrintMinutesTimeLapse(){
        TimeLapse minutesLapse = new TimeLapse(0L, 0L, 15L, 0L);
        String minutesPrint = this.ui.timeLapse(minutesLapse);
        Assert.assertEquals("(15 minutes ago)", minutesPrint);
    }

    @Test
    public void shouldPrintHoursTimeLapse(){
        TimeLapse hoursLapse = new TimeLapse(0L, 1L, 0L, 0L);
        String hoursPrint = this.ui.timeLapse(hoursLapse);
        Assert.assertEquals("(1 hour ago)", hoursPrint);
    }

    @Test
    public void shouldPrintDaysTimeLapse(){
        TimeLapse daysLapse = new TimeLapse(1L, 0L, 0L, 0L);
        String daysPrint = this.ui.timeLapse(daysLapse);
        Assert.assertEquals("(1 day ago)", daysPrint);
    }

    @Test
    public void shouldPrintWall(){
        User joan = new User("Joan");
        joan.getWall().addPost(joan, "Hello there!");
        User andy = new User("Andy");
        andy.getWall().addPost(andy, "This is Andy");
        joan.addUserToFollow(andy);

        String wallPrint = this.ui.wall(joan);
        Assert.assertTrue(wallPrint.split("\n")[0].contains("Joan -> Hello there!"));
        Assert.assertTrue(wallPrint.split("\n")[1].contains("Andy -> This is Andy"));
    }
}
