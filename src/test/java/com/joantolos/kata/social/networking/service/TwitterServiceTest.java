package com.joantolos.kata.social.networking.service;

import com.joantolos.kata.social.networking.ui.UserInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterServiceTest {

    private TwitterService twitterService;

    @Before
    public void setUp(){
        this.twitterService = new TwitterService(new UserInterface());
    }

    @Test
    public void shouldPost() {
        Assert.assertEquals("Message posted!", twitterService.post("Alice", "I love the weather today"));
    }

    @Test
    public void shouldFollow(){
        Assert.assertEquals("Alice now follows Bob", twitterService.follow("Alice", "Bob"));
    }

}
