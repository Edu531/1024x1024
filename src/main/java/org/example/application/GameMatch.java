package org.example.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Board;
import org.example.entity.enums.AnsiColorEnum;
import org.example.exception.KeyException;

import java.util.Scanner;

public class GameMatch {
    static final Logger logger = LogManager.getLogger(GameMatch.class);

    private Board board;
    private Scanner scanner;
    private boolean isGameOver = true;

    public GameMatch() {
        logger.info("GameMatch constructor");
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
        } catch (KeyException keyException) {
            UI.println(keyException.getMessage(), AnsiColorEnum.ANSI_RED);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public boolean canMove() {
        logger.fatal("Não implementado");
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
