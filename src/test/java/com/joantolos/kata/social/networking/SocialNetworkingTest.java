package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;
import org.junit.Assert;
import org.junit.Test;

public class SocialNetworkingTest {

    @Test
    public void shouldPost(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        Assert.assertEquals("Message posted!\n", socialNetworking.processCommand("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPost(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        Assert.assertEquals("", socialNetworking.processCommand("Joan -< Hello there"));
    }

    @Test
    public void shouldRead(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        socialNetworking.processCommand("Joan -> Hello there");
        String readResult = socialNetworking.processCommand("Joan");
        Assert.assertTrue(readResult.split("\n")[0].contains("Hello there"));
    }

    @Test
    public void shouldReadWhenSeveralPosts(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        socialNetworking.processCommand("Joan -> Hello there");
        socialNetworking.processCommand("Joan -> I am happy");
        String readResult = socialNetworking.processCommand("Joan");
        Assert.assertTrue(readResult.split("\n")[0].contains("I am happy"));
        Assert.assertTrue(readResult.split("\n")[1].contains("Hello there"));
    }

    @Test
    public void shouldReadWhenSeveralUsersPosting(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        socialNetworking.processCommand("Joan -> Hello there");
        socialNetworking.processCommand("Andy -> I am happy");
        String joanReadResult = socialNetworking.processCommand("Joan");
        Assert.assertTrue(joanReadResult.split("\n")[0].contains("Hello there"));
        String andyReadResult = socialNetworking.processCommand("Andy");
        Assert.assertTrue(andyReadResult.split("\n")[0].contains("I am happy"));
    }

    @Test
    public void shouldFollow(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        Assert.assertEquals("Joan now follows Andy\n", socialNetworking.processCommand("Joan follows Andy"));
    }

    @Test
    public void shouldShowWall(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        socialNetworking.processCommand("Joan -> Hello there");
        socialNetworking.processCommand("Joan -> I am happy");
        String wallResult = socialNetworking.processCommand("Joan");
        Assert.assertTrue(wallResult.split("\n")[0].contains("I am happy"));
        Assert.assertTrue(wallResult.split("\n")[1].contains("Hello there"));
    }

    @Test
    public void shouldShowWallWhenFollowedUsers(){
        try {
            SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
            socialNetworking.processCommand("Joan -> Hello there");
            Thread.sleep(500);
            socialNetworking.processCommand("Andy -> This is Andy");
            Thread.sleep(500);
            socialNetworking.processCommand("Joan follows Andy");
            socialNetworking.processCommand("Joan -> I am happy");
            Thread.sleep(500);
            String wallResult = socialNetworking.processCommand("Joan wall");
            Assert.assertTrue(wallResult.split("\n")[0].contains("Joan -> I am happy"));
            Assert.assertTrue(wallResult.split("\n")[1].contains("Andy -> This is Andy"));
            Assert.assertTrue(wallResult.split("\n")[2].contains("Joan -> Hello there"));
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    @Test
    public void shouldPrintResult(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        Assert.assertTrue(socialNetworking.printCommandResult("Joan -> Hello there"));
    }

    @Test
    public void shouldNotPrintResult(){
        SocialNetworking socialNetworking = new SocialNetworking(new UserInterface());
        Assert.assertFalse(socialNetworking.printCommandResult(""));
    }

}
