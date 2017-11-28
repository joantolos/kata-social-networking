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
    public void shouldPrintWallWithFollowedUsers() {
        twitterService.post("Alice", "Alice writes a message first.");
        twitterService.post("Bob", "Bob writes a message second.");
        twitterService.follow("Alice", "Bob");
        Assert.assertTrue(twitterService.wall("Alice").contains("Alice -> Alice writes a message first."));
        Assert.assertTrue(twitterService.wall("Alice").contains("Bob -> Bob writes a message second."));
    }

    @Test
    public void shouldPrintIncrementedTimeLapse() {
//        try {
//            twitterService.post("Alice", "Alice writes a message first.");
//            Thread.sleep(10000);
//            twitterService.post("Bob", "Bob writes a message second.");
//            Thread.sleep(5000);
//            twitterService.follow("Alice", "Bob");
//
//            String[] lines = twitterService.wall("Alice").split("\n");
//            Integer firstPostTime = Integer.valueOf(lines[0].substring(lines[0].indexOf("(") + 1, lines[0].length()).substring(0, lines[0].substring(lines[0].indexOf("(") + 1, lines[0].length()).indexOf(" ")));
//            Integer secondPostTime = Integer.valueOf(lines[1].substring(lines[1].indexOf("(") + 1, lines[1].length()).substring(0, lines[1].substring(lines[1].indexOf("(") + 1, lines[1].length()).indexOf(" ")));
//
//            Assert.assertTrue(firstPostTime > secondPostTime || secondPostTime > firstPostTime);
//
//        } catch (InterruptedException e) {
//            Assert.fail();
//        }
    }
}
