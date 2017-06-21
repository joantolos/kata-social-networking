package com.workshop.tdd;

/**
 * Created by joan on 21/06/2017.
 */
public class TicTacToe {

    private Integer[][] board;
    private int lastPlayer;

    public TicTacToe(int x, int y){
        this.board = new Integer[x][y];
    }

    public boolean isPositionEmpty(int x, int y){
        return this.board[x][y]==null;
    }

    public String play(int player, int x, int y){
        if(this.lastPlayer == player){
            return "Can not move again";
        }
        this.lastPlayer = player;
        if(isPositionEmpty(x,y)) {
            this.board[x][y] = player;
            return "Move done!";
        }else {
            return "Can not move there, position in use";
        }
    }
}
