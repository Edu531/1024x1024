package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.AnsiColorEnum;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GameMatch {

    private Board board;
    private Scanner scanner;
    private boolean isGameOver = true;

    public GameMatch() {
    }

    public GameMatch(Board board) {
        this.board = board;
    }

    public void startMatch(Scanner scanner) {
        board = Board.defaltBoard();
        this.scanner = scanner;
        setGameOver(false);
        UI.clearScreen();
        System.out.println("Start match");
    }

    public void startRound() {
        UI.clearScreen();
        UI.printMatch(board);
        movePieces(2);
        if (!canMove()) {
            setGameOver(true);
        }
    }

    public void movePieces(Integer numeroAdicional) {
        try {
            BoardMovement.movePieces(UI.readMoveDirection(scanner), numeroAdicional, board);
        } catch (Exception e) {
            UI.println(e.getMessage(), AnsiColorEnum.ANSI_RED);
        }
    }

    public boolean canMove() {
        return Arrays.stream(board.getTable()).anyMatch(row -> Arrays.stream(row).anyMatch(Objects::isNull));
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
