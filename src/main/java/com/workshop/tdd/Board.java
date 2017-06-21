package com.workshop.tdd;

/**
 * Created by joan on 21/06/2017.
 */
public class Board {

    private Integer[][] board;

    public Board(int x, int y){
        this.board = new Integer[x][y];
    }

    public boolean isEmpty(int x, int y){
        return this.board[x][y]==null;
    }
}
