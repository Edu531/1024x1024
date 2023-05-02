package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;

import java.security.SecureRandom;
import java.util.Objects;

public class BoardMovement {

    private BoardMovement() {
    }

    public static void movePieces(KeyDirectionEnum keyDirectionEnum, int numeroAdicional, Board board) {
        Integer[][] matriz = board.getTable();
        switch (keyDirectionEnum) {
            case UP -> moveUp(matriz);
            case DOWN -> moveDown(matriz);
            case LEFT -> moveLeft(matriz);
            case RIGHT -> moveRight(matriz);
            default -> throw new IllegalArgumentException("Invalid key");
        }

        includesNewPieceInRandonPlace(matriz, numeroAdicional);
    }

    private static void includesNewPieceInRandonPlace(Integer[][] matriz, int numeroAdicional) {
        int linha;
        int coluna;
        do {
            linha = new SecureRandom().nextInt(matriz.length);
            coluna = new SecureRandom().nextInt(matriz[0].length);
        } while (matriz[linha][coluna] != null);

        matriz[linha][coluna] = numeroAdicional;
    }

    private static void moveRight(Integer[][] matriz) {
        for (Integer[] coluna : matriz) {
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

    private static void moveLeft(Integer[][] matriz) {
       for (Integer[] coluna : matriz) {
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

    private static void moveDown(Integer[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Integer[] coluna = matriz[i];
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && i != matriz.length - 1) {
                    Integer nextPiece = matriz[i + 1][j];
                    if (Objects.isNull(nextPiece)) {
                        matriz[i + 1][j] = piece;
                        matriz[i][j] = null;
                    } else if (piece.equals(nextPiece)) {
                        matriz[i + 1][j] = piece * 2;
                        matriz[i][j] = null;
                    }
                }
            }
        }
    }

    private static void moveUp(Integer[][] matriz) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            Integer[] coluna = matriz[i];
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && i != 0) {
                    Integer nextPiece = matriz[i - 1][j];
                    if (Objects.isNull(nextPiece)) {
                        matriz[i - 1][j] = piece;
                        matriz[i][j] = null;
                    } else if (piece.equals(nextPiece)) {
                        matriz[i - 1][j] = piece * 2;
                        matriz[i][j] = null;
                    }
                }
            }
        }
    }
}
