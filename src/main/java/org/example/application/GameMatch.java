package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.AnsiColorEnum;

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
        UI.printMatch(board);
    }

    public void startRound() {
        UI.clearScreen();
        UI.printMatch(board);
        movePiece();
    }

    public void movePiece() {
        try {
            BoardMovement.movePieces(UI.readMoveDirection(scanner), board);
        } catch (Exception e) {
            UI.println(e.getMessage(), AnsiColorEnum.ANSI_RED);
        }
    }

    public boolean canMove() {
        UI.println("Não implementado");
        return true;
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
