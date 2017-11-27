package com.joantolos.kata.social.networking.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User alice;

    @Before
    public void setUp(){
        this.alice = new User("Alice");
    }

    @Test
    public void shouldHaveWall(){
        Assert.assertNotNull(this.alice.getWall());
    }

    @Test
    public void shouldPrintWall(){
        alice.getWall().addPost(new User("Joan"),"My post");
        Assert.assertTrue(alice.printWall().contains("Joan -> My post"));
    }

    @Test
    public void shouldPrintWallWhenSeveralPosts(){
        alice.getWall().addPost(new User("Alice"),"My post");
        alice.getWall().addPost(new User("Alice"),"My second post!");
        Assert.assertTrue(alice.printWall().contains("Alice -> My post"));
        Assert.assertTrue(alice.printWall().contains("Alice -> My second post!"));
    }
}
