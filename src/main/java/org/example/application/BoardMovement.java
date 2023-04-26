package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;

import java.util.Objects;

public class BoardMovement {

    private BoardMovement() {
    }

    public static void movePieces(KeyDirectionEnum keyDirectionEnum, Board board) {
        Integer[][] matrix = board.getTable();
        for (Integer[] coluna : matrix) {
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && j != coluna.length - 1) {
                    Integer nextPiece = coluna[j + 1];
                    if (Objects.isNull(nextPiece)) {
                        coluna[j + 1] = piece;
                        coluna[j] = null;
                    } else if (piece.equals(nextPiece)) {
                        coluna[j + 1] = piece * 2;
                        coluna[j] = null;
                    }
                }
            }
        }
    }
}
