package com.joantolos.kata.social.networking.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterServiceTest {

    private TwitterService twitterService;

    @Before
    public void setUp(){
        this.twitterService = new TwitterService();
    }

    @Test
    public void shouldPost() {
        Assert.assertEquals("Message posted!", twitterService.post("Alice", "I love the weather today"));
    }

    @Test
    public void shouldFollow(){
        Assert.assertEquals("Alice now follows Bob", twitterService.follow("Alice", "Bob"));
    }

    @Test
    public void shouldShowWall(){
        twitterService.post("Joan", "My very first message");
        Assert.assertEquals("Joan -> My very first message\n", twitterService.wall("Joan"));
    }

    @Test
    public void shouldAddUser() {
        twitterService.post("Joan", "My very first message");
        Assert.assertNotNull(twitterService.getUsers().stream().filter(user -> user.getName().equals("Joan")).findFirst().orElse(null));
    }
}
