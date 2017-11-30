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
        String readResult = twitter.processCommand("Joan");
        Assert.assertTrue(readResult.split("\n")[0].contains("Hello there"));
        Assert.assertTrue(readResult.split("\n")[1].contains("I am happy"));
    }

    @Test
    public void shouldReadWhenSeveralUsersPosting(){
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Andy -> I am happy");
        String joanReadResult = twitter.processCommand("Joan");
        Assert.assertTrue(joanReadResult.split("\n")[0].contains("Hello there"));
        String andyReadResult = twitter.processCommand("Andy");
        Assert.assertTrue(andyReadResult.split("\n")[0].contains("I am happy"));
    }

    @Test
    public void shouldFollow(){
        Assert.assertEquals(" Joan now follows Andy\n", twitter.processCommand("Joan follows Andy"));
    }

    @Test
    public void shouldShowWall(){
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Joan -> I am happy");
        String wallResult = twitter.processCommand("Joan");
        Assert.assertTrue(wallResult.split("\n")[0].contains("Hello there"));
        Assert.assertTrue(wallResult.split("\n")[1].contains("I am happy"));
    }

    @Test
    public void shouldShowWallWhenFollowedUsers(){
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Andy -> This is Andy");
        twitter.processCommand("Joan follows Andy");
        twitter.processCommand("Joan -> I am happy");
        String wallResult = twitter.processCommand("Joan wall");
        Assert.assertTrue(wallResult.split("\n")[0].contains("Hello there"));
        Assert.assertTrue(wallResult.split("\n")[1].contains("This is Andy"));
        Assert.assertTrue(wallResult.split("\n")[2].contains("I am happy"));
    }

    @Test
    public void shouldPrintResult(){
        Assert.assertTrue(twitter.printCommandResult("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPrintResult(){
        Assert.assertFalse(twitter.printCommandResult(""));
    }

}
