package com.joantolos.kata.tictactoe.game;

import com.joantolos.kata.tictactoe.exception.MoveNotAvailableException;
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
    public void shouldRecordMove() throws MoveNotAvailableException {
        board.recordMove(0,1, "X");
        Assert.assertEquals("\tX\t", board.getBoxStatus(0, 1));
    }

    @Test(expected = MoveNotAvailableException.class)
    public void shouldFailWhenBoxIsInUse() throws MoveNotAvailableException {
        board.recordMove(0,1, "X");
        board.recordMove(0,1, "X");
    }

    @Test
    public void shouldPrint(){
        Assert.assertNotNull(board.print());
    }
}
