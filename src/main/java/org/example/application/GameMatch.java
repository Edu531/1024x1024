package org.example.application;

import org.example.entity.Board;
import org.example.exception.GameException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GameMatch {

    private Board board;
    private final Scanner scanner;
    private boolean isGameOver = true;

    public GameMatch(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMatch() {
        board = Board.defaltBoard();
        setGameOver(false);
        UI.clearScreen();
        UI.startMatchMessage(scanner);
    }

    public void startRound() {
        UI.clearScreen();
        UI.printMatch(board);
        movePieces();
        if (!canMove()) {
            setGameOver(true);
        }
    }

    public void movePieces() {
        try {
            BoardMovement.movePieces(UI.readMoveDirection(scanner), board);
        } catch (GameException e) {
            printError(e.getMessage());
        }
    }

    public boolean canMove() {
        if (Arrays.stream(board.getTable()).noneMatch(row -> Arrays.stream(row).anyMatch(Objects::isNull))) {
            return BoardMovement.hasPossibleMoves(board.getTable());
        }
        return true;
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
