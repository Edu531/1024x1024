package org.example.application;

import org.example.entity.Board;

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
        UI.startMatch(scanner);
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
            printError(e.getMessage());
        }
    }

    public boolean canMove() {
        return Arrays.stream(board.getTable()).anyMatch(row -> Arrays.stream(row).anyMatch(Objects::isNull));
    }

    public void printGameOver() {
        UI.printGameOver(board);
    }

    public void printError(String message) {
        if (Objects.isNull(scanner)) {
            final Scanner temporaryScanner = new Scanner(System.in);
            UI.printError(message, temporaryScanner);
            temporaryScanner.nextLine();
            temporaryScanner.close();
        } else {
            UI.printError(message, scanner);
            scanner.nextLine();
        }
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
