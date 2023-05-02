package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.KeyDirectionEnum;

import java.security.SecureRandom;
import java.util.Objects;

public class BoardMovement {

    private BoardMovement() {
    }

    public static void movePieces(KeyDirectionEnum keyDirectionEnum, Integer numeroAdicional, Board board) {
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

    private static void moveRight(Integer[][] matriz) {
        moveLineRight(matriz);
        combineRight(matriz);
        moveLineRight(matriz);
    }

    private static void moveLeft(Integer[][] matriz) {
        moveLineLeft(matriz);
        combineLeft(matriz);
        moveLineLeft(matriz);
    }

    private static void moveDown(Integer[][] matriz) {
        moveColumnDown(matriz);
        combineDown(matriz);
        moveColumnDown(matriz);
    }

    private static void moveUp(Integer[][] matriz) {
        moveColumnUp(matriz);
        combineUp(matriz);
        moveColumnUp(matriz);
    }

    private static void moveLineRight(Integer[][] matriz) {
        for (Integer[] linha : matriz) {
            for (int j = linha.length - 1; j >= 0; j--) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece) && j != matriz.length - 1) {
                    moverParaOFimDaLinha(1, linha, j);
                }
            }
        }
    }

    private static void moveLineLeft(Integer[][] matriz) {
        for (Integer[] linha : matriz) {
            for (int j = 0; j < linha.length; j++) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece) && j != 0) {
                    moverParaOFimDaLinha(-1, linha, j);
                }
            }
        }
    }

    private static void moverParaOFimDaLinha(int index, Integer[] linha, int j) {
        if (j + index >= 0 && Objects.isNull(linha[j + index])) {
            linha[j + index] = linha[j];
            linha[j] = null;
        }
        if (linha.length > j + (index + 1) && Objects.isNull(linha[j + (index + 1)])) {
            moverParaOFimDaLinha(index, linha, j + index);
        }
    }

    private static void combineRight(Integer[][] matriz) {
        for (Integer[] linha : matriz) {
            for (int j = linha.length - 1; j >= 0; j--) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece)) {
                    combinarPieceLine(-1, linha, j);
                }
            }
        }
    }

    private static void combineLeft(Integer[][] matriz) {
        for (Integer[] linha : matriz) {
            for (int j = 0; j < linha.length; j++) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece)) {
                    combinarPieceLine(1, linha, j);
                }
            }
        }
    }

    private static void combinarPieceLine(int index, Integer[] linha, int j) {
        if (j + index >= 0 && j + index < linha.length && linha[j].equals(linha[j + index])) {
            linha[j] = linha[j] * 2;
            linha[j + index] = null;
        }
    }

    private static void combineDown(Integer[][] matriz) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            Integer[] linha = matriz[i];
            for (int j = 0; j < linha.length; j++) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece) && i != matriz.length - 1) {
                    combineColumn(1, matriz, i, j);
                }
            }
        }
    }

    private static void combineColumn(int index, Integer[][] matriz, int i, int j) {
        if (i + index >= 0
                && i + index < matriz.length
                && Objects.nonNull(matriz[i + index][j])
                && (matriz[i][j].equals(matriz[i + index][j]))) {
                matriz[i][j] = matriz[i][j] * 2;
                matriz[i + index][j] = null;
        }
    }

    private static void moveColumnDown(Integer[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Integer[] linha = matriz[i];
            for (int j = linha.length - 1; j >= 0; j--) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece) && i != matriz.length - 1) {
                    moverParaOFimDaColuna(1, matriz, i, j);
                }
            }
        }
    }

    private static void combineUp(Integer[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Integer[] coluna = matriz[i];
            for (int j = 0; j < coluna.length; j++) {
                Integer piece = coluna[j];
                if (Objects.nonNull(piece) && i != matriz.length - 1) {
                    combineColumn(-1, matriz, i, j);
                }
            }
        }
    }

    private static void moveColumnUp(Integer[][] matriz) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            Integer[] linha = matriz[i];
            for (int j = 0; j < linha.length; j++) {
                Integer piece = linha[j];
                if (Objects.nonNull(piece) && i != 0) {
                    moverParaOFimDaColuna(-1, matriz, i, j);
                }
            }
        }
    }

    private static void moverParaOFimDaColuna(int index, Integer[][] matriz, int i, int j) {
        if (i + index >= 0 && Objects.isNull(matriz[i + index][j])) {
            matriz[i + index][j] = matriz[i][j];
            matriz[i][j] = null;
        }
        if (matriz.length > i + (index + 1) && Objects.isNull(matriz[i + (index + 1)][j])) {
            moverParaOFimDaColuna(index, matriz, i + index, j);
        }
    }

    private static void includesNewPieceInRandonPlace(Integer[][] matriz, Integer numeroAdicional) {
        SecureRandom secureRandom = new SecureRandom();
        int linha, coluna;
        do {
            linha = secureRandom.nextInt(matriz.length);
            coluna = secureRandom.nextInt(matriz[0].length);
        } while (matriz[linha][coluna] != null);

        matriz[linha][coluna] = numeroAdicional;
    }
}
