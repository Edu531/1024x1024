package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;
import org.example.exception.MovementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardMovementTest {

    @Test
    void testMovePiecesRight() {
        Board board = Board.defaltBoard();
        board.setAdditionalNumber(null);
        BoardMovement.movePieces(KeyDirectionEnum.RIGHT, board);
        assertEquals(4, board.getTable()[0][3]);

        board.setTable(new Integer[][] {
                {2, 2, 2, 2},
                {8, null, 8, null},
                {null, null, null, null},
                {null, 4, null, 4}
        });
        BoardMovement.movePieces(KeyDirectionEnum.RIGHT, board);
        assertEquals(4, board.getTable()[0][3]);
        assertEquals(4, board.getTable()[0][2]);
        assertEquals(16, board.getTable()[1][3]);
        assertEquals(8, board.getTable()[3][3]);
    }

    @Test
    void testMovePiecesLeft() {
        Board board = Board.defaltBoard();
        board.setAdditionalNumber(null);
        BoardMovement.movePieces(KeyDirectionEnum.LEFT, board);
        assertEquals(4, board.getTable()[0][0]);

        board.setTable(new Integer[][] {
                {2, 2, 2, 2},
                {8, null, 8, null},
                {null, null, null, null},
                {null, 4, null, 4}
        });
        BoardMovement.movePieces(KeyDirectionEnum.LEFT, board);
        assertEquals(4, board.getTable()[0][0]);
        assertEquals(4, board.getTable()[0][1]);
        assertEquals(16, board.getTable()[1][0]);
        assertEquals(8, board.getTable()[3][0]);
    }

    @Test
    void testMovePiecesDown() {
        Board board = Board.defaltBoard();
        board.setAdditionalNumber(null);
        BoardMovement.movePieces(KeyDirectionEnum.DOWN, board);
        assertEquals(2, board.getTable()[3][0]);
        assertEquals(2, board.getTable()[3][1]);

        board.setTable(new Integer[][] {
                {2, null, null, 4},
                {2, null, 8, null},
                {2, null, null, 4},
                {2, null, 8, null}
        });
        BoardMovement.movePieces(KeyDirectionEnum.DOWN, board);
        assertEquals(4, board.getTable()[2][0]);
        assertEquals(4, board.getTable()[3][0]);
        assertEquals(16, board.getTable()[3][2]);
        assertEquals(8, board.getTable()[3][3]);
    }

    @Test
    void testMovePiecesUp() {
        Board board = Board.defaltBoard();
        board.setAdditionalNumber(null);
        assertThrows(MovementException.class, () -> BoardMovement.movePieces(KeyDirectionEnum.UP, board));

        board.setTable(new Integer[][] {
                {2, null, null, 4},
                {2, null, 8, null},
                {2, null, null, 4},
                {2, null, 8, null}
        });
        BoardMovement.movePieces(KeyDirectionEnum.UP, board);
        assertEquals(4, board.getTable()[0][0]);
        assertEquals(4, board.getTable()[1][0]);
        assertEquals(16, board.getTable()[0][2]);
        assertEquals(8, board.getTable()[0][3]);
    }

    @Test
    void testMoveInvalidException() {
        Board board = Board.defaltBoard();
        board.setAdditionalNumber(null);
        assertThrows(MovementException.class, () -> BoardMovement.movePieces(KeyDirectionEnum.UP, board));
    }
}
