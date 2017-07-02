package com.joantolos.kata.tictactoe.game;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        this.board = new Board();
    }

    @After
    public void tearDown(){
        this.board = null;
    }

    @Test
    public void shouldRecordMove(){
        board.recordMove(0,1, "X");
        Assert.assertEquals("X", board.getBoxStatus(0, 1));
    }

    @Test
    public void shouldPrint(){
        Assert.assertNotNull(board.print());
    }
}
