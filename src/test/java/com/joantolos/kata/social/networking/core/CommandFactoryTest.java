package com.joantolos.kata.social.networking.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {

    private String postCommand;
    private String readCommand;
    private String followCommand;
    private String wallCommand;

    @Before
    public void setUp(){
        this.postCommand = "Joan -> Hello there";
        this.readCommand = "Joan";
        this.followCommand = "Joan follows Andy";
        this.wallCommand = "Joan wall";
    }

    @Test
    public void shouldRecognizePostCommand(){
        Command command = CommandFactory.build(postCommand);
        Assert.assertTrue(command instanceof PostCommand);
    }

    @Test
    public void shouldRecognizeReadCommand(){
        Command command = CommandFactory.build(readCommand);
        Assert.assertTrue(command instanceof ReadCommand);
    }

    @Test
    public void shouldRecognizeFollowCommand(){
        Command command = CommandFactory.build(followCommand);
        Assert.assertTrue(command instanceof FollowCommand);
    }

    @Test
    public void shouldRecognizeWallPost(){
        Command command = CommandFactory.build(wallCommand);
        Assert.assertTrue(command instanceof WallCommand);
    }
}
