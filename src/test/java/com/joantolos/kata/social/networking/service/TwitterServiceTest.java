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
        Assert.assertTrue(twitterService.wall("Joan").contains("Joan -> My very first message"));
    }

    @Test
    public void shouldAddUser() {
        twitterService.post("Joan", "My very first message");
        Assert.assertNotNull(twitterService.getUsers().stream().filter(user -> user.getName().equals("Joan")).findFirst().orElse(null));
    }

    @Test
    public void shouldPrintWallWithFollowedUsers() {
        twitterService.post("Alice", "Alice writes a message first.");
        twitterService.post("Bob", "Bob writes a message second.");
        twitterService.follow("Alice", "Bob");
        Assert.assertTrue(twitterService.wall("Alice").contains("Alice -> Alice writes a message first."));
        Assert.assertTrue(twitterService.wall("Alice").contains("Bob -> Bob writes a message second."));
    }
}
