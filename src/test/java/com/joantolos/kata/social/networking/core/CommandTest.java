package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.ui.UserInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandTest {

    private Command command;

    @Before
    public void setUp(){
        this.command = new Command(new UserInterface());
    }

    @Test
    public void shouldProcessPost(){
        Assert.assertFalse(this.command.process("Joan posting Hello"));
    }

    @Test
    public void shouldProcessFollow(){
        Assert.assertFalse(this.command.process("Joan following Jane"));
    }

    @Test
    public void shouldProcessWall(){
        Assert.assertFalse(this.command.process("Joan wall"));
    }

    @Test
    public void shouldProcessExit(){
        Assert.assertTrue(this.command.process("Joan exit"));
    }
}
