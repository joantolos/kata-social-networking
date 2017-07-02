package com.joantolos.kata.tictactoe;

import java.util.Arrays;

public class Board {

    private String[][] boxes;

    public Board(){
        boxes = createEmptyBoard();
    }

    private String[][] createEmptyBoard() {
        String[][] emptyBoard = new String[3][3];
        emptyBoard[0][0] = "\t \t";
        emptyBoard[0][1] = "\t \t";
        emptyBoard[0][2] = "\t \t";
        emptyBoard[1][0] = "\t \t";
        emptyBoard[1][1] = "\t \t";
        emptyBoard[1][2] = "\t \t";
        emptyBoard[2][0] = "\t \t";
        emptyBoard[2][1] = "\t \t";
        emptyBoard[2][2] = "\t \t";
        return emptyBoard;
    }

    void print(){
        for(String[] boxRow : boxes) {
            System.out.println(Arrays.deepToString(boxRow));
        }
    }
}
