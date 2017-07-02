package com.joantolos.kata.tictactoe.game;

import com.joantolos.kata.tictactoe.exception.MoveNotAvailableException;

import java.util.Arrays;

public class Board {

    private String[][] boxes;

    public Board(){
        boxes = createEmptyBoard();
    }

    public String print(){
        StringBuilder boardForPrinting = new StringBuilder();
        for(String[] boxRow : boxes) {
            boardForPrinting.append(Arrays.deepToString(boxRow)).append("\n");
        }
        return boardForPrinting.toString();
    }

    public void recordMove(int x, int y, String symbol) throws MoveNotAvailableException {
        if(boxes[x][y].equals("\t \t")) {
            boxes[x][y] = "\t" + symbol + "\t";
        } else {
            throw new MoveNotAvailableException();
        }
    }

    public String getBoxStatus(int x, int y){
        return boxes[x][y];
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
}
