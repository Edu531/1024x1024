package org.example.entity;

public class Board {
    private Integer[][] table;

    private Board(int rows, int columns) {
        this.table = new Integer[rows][columns];
    }

    public static Board defaltBoard() {
        Board board = new Board(4, 4);
        board.getTable()[0][0] = 2;
        board.getTable()[0][1] = 2;
        return board;
    }

    public Integer[][] getTable() {
        return table;
    }

    public void setTable(Integer[][] table) {
        this.table = table;
    }
}
