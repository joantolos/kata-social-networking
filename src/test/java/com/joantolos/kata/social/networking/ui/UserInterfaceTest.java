package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Post> postToPrint = new ArrayList<>();
        postToPrint.add(new Post(new User("Joan"), "Hello there"));
        String wallPrint = this.ui.wall(postToPrint);
        Assert.assertTrue(wallPrint.split("\n")[0].contains("Joan -> Hello there"));
    }
}
