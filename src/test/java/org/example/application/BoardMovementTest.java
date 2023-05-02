package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardMovementTest {

    @Test
    void testMovePiecesRight() {
        Board board = Board.defaltBoard();
        Integer[][] expectedTable = new Integer[][] {
                {null, null, null, 4},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };
        BoardMovement.movePieces(KeyDirectionEnum.RIGHT, null, board);
        assertEquals(expectedTable[0][3], board.getTable()[0][3]);
    }

    @Test
    void testMovePiecesLeft() {
        Board board = Board.defaltBoard();
        Integer[][] expectedTable = new Integer[][] {
                {4, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };
        BoardMovement.movePieces(KeyDirectionEnum.LEFT, null, board);
        assertEquals(expectedTable[0][0], board.getTable()[0][0]);
    }

    @Test
    void testMovePiecesDown() {
        Board board = Board.defaltBoard();
        BoardMovement.movePieces(KeyDirectionEnum.DOWN, null, board);
        assertEquals(2, board.getTable()[3][0]);
        assertEquals(2, board.getTable()[3][1]);

        board.setTable(new Integer[][] {
                {2, null, null, null},
                {2, null, null, null},
                {2, null, null, null},
                {2, null, null, null}
        });
        BoardMovement.movePieces(KeyDirectionEnum.DOWN, null, board);
        assertEquals(4, board.getTable()[2][0]);
        assertEquals(4, board.getTable()[3][0]);

        board.setTable(new Integer[][] {
                {2, null, null, 4},
                {2, null, 8, null},
                {2, null, null, 4},
                {2, null, 8, null}
        });
        BoardMovement.movePieces(KeyDirectionEnum.DOWN, null, board);
        assertEquals(4, board.getTable()[2][0]);
        assertEquals(4, board.getTable()[3][0]);
        assertEquals(16, board.getTable()[3][2]);
//        assertEquals(8, board.getTable()[3][3]);
    }

    @Test
    void testMovePiecesUp() {
        Board board = Board.defaltBoard();
        Integer[][] expectedTable = new Integer[][] {
                {2, 2, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };
        BoardMovement.movePieces(KeyDirectionEnum.UP, null, board);
        assertEquals(expectedTable[0][0], board.getTable()[0][0]);
        assertEquals(expectedTable[0][1], board.getTable()[0][1]);
    }
}
