package com.joantolos.kata.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        board = new Board();
    }

    @After
    public void tearDown(){
        board = null;
    }

    @Test
    public void printTest(){
        board.print();
    }
}
