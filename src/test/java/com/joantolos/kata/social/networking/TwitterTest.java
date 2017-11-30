package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TwitterTest {

    @Test
    public void shouldPost(){
        Twitter twitter = new Twitter(new UserInterface());
        Assert.assertEquals(" Message posted!\n", twitter.processCommand("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPost(){
        Twitter twitter = new Twitter(new UserInterface());
        Assert.assertEquals("", twitter.processCommand("Joan -< Hello there"));
    }

    @Test
    public void shouldRead(){
        Twitter twitter = new Twitter(new UserInterface());
        twitter.processCommand("Joan -> Hello there");
        Assert.assertEquals(" Hello there \n", twitter.processCommand("Joan"));
    }

    @Test
    public void shouldReadWhenSeveralPosts(){
        Twitter twitter = new Twitter(new UserInterface());
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Joan -> I am happy");
        String readResult = twitter.processCommand("Joan");
        Assert.assertTrue(readResult.split("\n")[0].contains(" Hello there"));
        Assert.assertTrue(readResult.split("\n")[1].contains(" I am happy"));
    }

    @Test
    public void shouldReadWhenSeveralUsersPosting(){
        Twitter twitter = new Twitter(new UserInterface());
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Andy -> I am happy");
        String joanReadResult = twitter.processCommand("Joan");
        Assert.assertTrue(joanReadResult.split("\n")[0].contains(" Hello there"));
        String andyReadResult = twitter.processCommand("Andy");
        Assert.assertTrue(andyReadResult.split("\n")[0].contains(" I am happy"));
    }

    @Test
    public void shouldFollow(){
        Twitter twitter = new Twitter(new UserInterface());
        Assert.assertEquals(" Joan now follows Andy\n", twitter.processCommand("Joan follows Andy"));
    }

    @Test
    public void shouldShowWall(){
        Twitter twitter = new Twitter(new UserInterface());
        twitter.processCommand("Joan -> Hello there");
        twitter.processCommand("Joan -> I am happy");
        String wallResult = twitter.processCommand("Joan");
        Assert.assertTrue(wallResult.split("\n")[0].contains(" Hello there"));
        Assert.assertTrue(wallResult.split("\n")[1].contains(" I am happy"));
    }

    @Test
    public void shouldShowWallWhenFollowedUsers(){
        try {
            Twitter twitter = new Twitter(new UserInterface());
            twitter.processCommand("Joan -> Hello there");
            Thread.sleep(500);
            twitter.processCommand("Andy -> This is Andy");
            Thread.sleep(500);
            twitter.processCommand("Joan follows Andy");
            twitter.processCommand("Joan -> I am happy");
            Thread.sleep(500);
            String wallResult = twitter.processCommand("Joan wall");
            Assert.assertTrue(wallResult.split("\n")[0].contains("Joan -> Hello there"));
            Assert.assertTrue(wallResult.split("\n")[1].contains("Andy -> This is Andy"));
            Assert.assertTrue(wallResult.split("\n")[2].contains("Joan -> I am happy"));
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    @Test
    public void shouldPrintResult(){
        Twitter twitter = new Twitter(new UserInterface());
        Assert.assertTrue(twitter.printCommandResult("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPrintResult(){
        Twitter twitter = new Twitter(new UserInterface());
        Assert.assertFalse(twitter.printCommandResult(""));
    }

}
