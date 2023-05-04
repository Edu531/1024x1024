package org.example.application;

import org.example.entity.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class GameMatchTest {
    @Mock
    Board board;

    @InjectMocks
    GameMatch gameMatch;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testStartMatch() {
//        when(board.defaltBoard()).thenReturn(null);
//
//        gameMatch.startMatch(null);
//    }
//
//    @Test
//    void testStartRound() {
//        when(board.getTable()).thenReturn(new Integer[][]{new Integer[]{Integer.valueOf(0)}});
//
//        gameMatch.startRound();
//    }
//
//    @Test
//    void testMovePieces() {
//        gameMatch.movePieces(Integer.valueOf(0));
//    }
//
    @Test
    void testCanMove() {
        when(board.getTable()).thenReturn(new Integer[][]{{null, 2}});
        assertTrue(gameMatch.canMove());
    }

    @Test
    void testNotCanMove() {
        when(board.getTable()).thenReturn(new Integer[][]{{2, 2}});
        assertFalse(gameMatch.canMove());
    }
}