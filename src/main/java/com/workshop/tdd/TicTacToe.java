package com.workshop.tdd;

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
        if(canMakeMove()){
            if(this.lastPlayer == player) {
                return "Can not move again";
            }
            if(isPositionEmpty(x,y)) {
                this.board[x][y] = player;
                this.lastPlayer = player;
                return "Move done!";
            }else {
                return "Can not move there, position in use";
            }
        }
        return "Game over! Nobody wins";
    }

    public boolean canMakeMove(){
        for (int x=0; x<this.board.length; x++){
            for (int y=0; y<this.board[x].length; y++) {
                if(isPositionEmpty(x,y)){
                    return true;
                }
            }
        }
        return false;
    }
}
