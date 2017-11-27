package com.joantolos.kata.social.networking.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WallTest {

    private Wall wall;

    @Before
    public void setUp(){
        this.wall = new Wall();
    }

    @Test
    public void shouldHavePosts(){
        Assert.assertNotNull(wall.getPosts());
    }

    @Test
    public void shouldAddPost(){
        wall.addPost(new User("Joan"), "My post");
        Assert.assertEquals("My post", wall.getPosts().get(0).getMessage());
    }
}
