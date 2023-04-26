package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;

import java.security.SecureRandom;
import java.util.Objects;

public class BoardMovement {

    private BoardMovement() {
    }

    public static void movePieces(KeyDirectionEnum keyDirectionEnum, Board board) {
        Integer[][] matrix = board.getTable();
        switch (keyDirectionEnum) {
            case UP -> moveUp(matrix);
            case DOWN -> moveDown(matrix);
            case LEFT -> moveLeft(matrix);
            case RIGHT -> moveRight(matrix);
            default -> throw new IllegalArgumentException("Invalid key");
        }

        includesNewPieceInRandonPlace(matrix);
    }

    private static void includesNewPieceInRandonPlace(Integer[][] matrix) {
        int numero = 2; //TODO - Ajustar para vir como parametro;
        int linha;
        int coluna;
        do {
            linha = new SecureRandom().nextInt(matrix.length);
            coluna = new SecureRandom().nextInt(matrix[0].length);
        } while (matrix[linha][coluna] != null);

        matrix[linha][coluna] = numero;
    }

    private static void moveRight(Integer[][] matrix) {
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

    private static void moveLeft(Integer[][] matrix) {
       for (Integer[] coluna : matrix) {
           for (int j = coluna.length - 1; j >= 0; j--) {
               Integer piece = coluna[j];
               if (Objects.nonNull(piece) && j != 0) {
                   Integer nextPiece = coluna[j - 1];
                   if (Objects.isNull(nextPiece)) {
                       coluna[j - 1] = piece;
                       coluna[j] = null;
                   } else if (piece.equals(nextPiece)) {
                       coluna[j - 1] = piece * 2;
                       coluna[j] = null;
                   }
               }
           }
       }
    }

    private static void moveDown(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Integer[] coluna = matrix[i];
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && i != matrix.length - 1) {
                    Integer nextPiece = matrix[i + 1][j];
                    if (Objects.isNull(nextPiece)) {
                        matrix[i + 1][j] = piece;
                        matrix[i][j] = null;
                    } else if (piece.equals(nextPiece)) {
                        matrix[i + 1][j] = piece * 2;
                        matrix[i][j] = null;
                    }
                }
            }
        }
    }

    private static void moveUp(Integer[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            Integer[] coluna = matrix[i];
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && i != 0) {
                    Integer nextPiece = matrix[i - 1][j];
                    if (Objects.isNull(nextPiece)) {
                        matrix[i - 1][j] = piece;
                        matrix[i][j] = null;
                    } else if (piece.equals(nextPiece)) {
                        matrix[i - 1][j] = piece * 2;
                        matrix[i][j] = null;
                    }
                }
            }
        }
    }
}
