package com.workshop.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        this.board = new Board();
    }

    @Test
    public void shouldExistsTestBoard(){
        Assert.assertNotNull(this.board);
    }
}
