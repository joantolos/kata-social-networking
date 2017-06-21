package com.workshop.tdd;

/**
 * Created by joan on 21/06/2017.
 */
public class TicTacToe {

    private Integer[][] board;

    public TicTacToe(int x, int y){
        this.board = new Integer[x][y];
    }

    public boolean isPositionEmpty(int x, int y){
        return this.board[x][y]==null;
    }

    public String play(int user, int x, int y){
        this.board[x][y] = user;
        if(user == 1) {
            return "Move done!";
        }else {
            return "Can not move there, position in use";
        }
    }
}
