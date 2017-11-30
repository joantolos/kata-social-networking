package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterTest {

    private Twitter twitter;

    @Before
    public void setUp(){
        this.twitter = new Twitter(new UserInterface());
    }

    @Test
    public void shouldPost(){
        Assert.assertEquals(" Message posted!\n", twitter.processCommand("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPost(){
        Assert.assertEquals("", twitter.processCommand("Joan -< Hello there"));
    }

    @Test
    public void shouldRead(){
        twitter.processCommand("Joan -> Hello there");
        Assert.assertEquals(" Hello there\n", twitter.processCommand("Joan"));
    }

    @Test
    public void shouldReadWhenSeveralPosts(){
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Joan -> I am happy");
        Assert.assertEquals(" Hello there\n I am happy\n", twitter.processCommand("Joan"));
    }

    @Test
    public void shouldFollow(){
        Assert.assertEquals(" Joan now follows Andy\n", twitter.processCommand("Joan follows Andy"));
    }

}
