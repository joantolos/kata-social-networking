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

    @Test
    public void shouldPrint(){
        wall.addPost(new User("Joan"),"My post");
        Assert.assertEquals("Joan -> My post\n", wall.print());
    }

    @Test
    public void shouldPrintWhenSeveralPosts(){
        wall.addPost(new User("Joan"),"My post");
        wall.addPost(new User("Joan"),"My second post!");
        Assert.assertEquals("Joan -> My post\nJoan -> My second post!\n", wall.print());
    }
}
