package com.joantolos.kata.tictactoe;

public class TicTacToe {

    private Integer[][] board;
    private Player lastPlayer;

    public TicTacToe(int x, int y){
        this.board = new Integer[x][y];
    }

    public boolean isPositionEmpty(int x, int y){
        return this.board[x][y]==null;
    }

    public String play(Player player, int x, int y){
        if(canMakeMove()){
            return performMove(player, x, y);
        }
        return "Game over! Nobody wins";
    }

    private String performMove(Player player, int x, int y) {
        if(this.lastPlayer == player) {
            return "Can not move again";
        }
        if(isPositionEmpty(x,y)) {
            this.board[x][y] = player.getId();
            this.lastPlayer = player;
            return "Move done!";
        }
        return "Can not move there, position in use";
    }

    public boolean canMakeMove(){
        for (int x=0; x<this.board.length; x++){
            if (isPositionAvailableOnRow(x)) return true;
        }
        return false;
    }

    private boolean isPositionAvailableOnRow(int x) {
        for (int y=0; y<this.board[x].length; y++) {
            if (isPositionEmpty(x, y)) return true;
        }
        return false;
    }
}
