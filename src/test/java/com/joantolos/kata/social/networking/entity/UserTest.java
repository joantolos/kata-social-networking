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
        Assert.assertEquals("Joan -> My post\n", alice.printWall());
    }

    @Test
    public void shouldPrintWallWhenSeveralPosts(){
        alice.getWall().addPost(new User("Joan"),"My post");
        alice.getWall().addPost(new User("Joan"),"My second post!");
        Assert.assertEquals("Joan -> My post\nJoan -> My second post!\n", alice.printWall());
    }
}
