package org.example.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Board;

public class GameMatch {
    static final Logger logger = LogManager.getLogger(GameMatch.class);

    private Board board;

    public GameMatch() {
        logger.info("GameMatch constructor");
    }

    public boolean canMove() {
        logger.fatal("Não implementado");
        return true;
    }

    public void startMatch() {
        board = Board.defaltBoard();
        UI.clearScreen();
        System.out.println("Start match");
        UI.printMatch(board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
