package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.AnsiColorEnum;
import org.example.entity.enums.KeyDirectionEnum;
import org.example.exception.ColorException;
import org.example.exception.KeyException;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class UI {
    private UI() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void print(String texto) {
        System.out.print(texto + AnsiColorEnum.ANSI_RESET.getColor());
    }

    public static void print(String texto, AnsiColorEnum ansiColorEnum) {
        System.out.print(Optional.ofNullable(ansiColorEnum).orElseThrow(() -> new ColorException("Color is required"))
                .getColor() + texto + AnsiColorEnum.ANSI_RESET.getColor());
    }

    public static void println(String texto) {
        System.out.println(texto + AnsiColorEnum.ANSI_RESET.getColor());
    }

    public static void println(String texto, AnsiColorEnum ansiColorEnum) {
        System.out.println(Optional.ofNullable(ansiColorEnum).orElseThrow(() -> new ColorException("Color is required"))
                .getColor() + texto + AnsiColorEnum.ANSI_RESET.getColor());
    }

    public static KeyDirectionEnum readMoveDirection(Scanner scanner) throws KeyException {
        return KeyDirectionEnum.getByKeyCode(scanner.next()).orElseThrow(() -> new KeyException("Tecla inválida"));
    }

    public static void printMatch(Board board) {
        printTable(board.getTable());
        println("");

//        printCapturedPieces(captured);
//        System.out.println();

//        System.out.println("Turn : " + chessMatch.getTurn());
//        if(!chessMatch.getCheckMate()) {
//            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
//            if (chessMatch.getCheck()) {
//                System.out.println("CHECK");
//            }
//        }
//        else {
//            System.out.println("CHECKMATE!");
//            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
//        }
    }


    public static void printTable(Integer[][] table) {
        for (int i = 0; i < table.length; i++) {
            print((table.length - i) + " ");
            for (int j = 0; j < table[i].length; j++) {
                printPiece(table[i][j], false);
            }
            println("");
        }
        println("  a b c d");
    }

//    public static void printTable(ChessPiece[][] pieces, boolean[][] possibleMoves) {
//        for (int i = 0; i < pieces.length; i++) {
//            System.out.print((8 - i) + " ");
//            for (int j = 0; j < pieces.length; j++) {
//                printPiece(pieces[i][j], possibleMoves[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("  a b c d e f g h");
//    }

    private static void printPiece(Integer piece, boolean background) {
        if (background) {
            print("", AnsiColorEnum.ANSI_BLUE_BACKGROUND);
        }
        if (Objects.isNull(piece)) {
            print("-");
        } else {
            print(piece.toString(), AnsiColorEnum.ANSI_YELLOW);
        }
        print(" ");
    }

//    private static void printCapturedPieces(List<ChessPiece> captured) {
//        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
//        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
//        System.out.println("Captured pieces: ");
//        System.out.print("white: ");
//        System.out.print(ANSI_WHITE);
//        System.out.println(Arrays.toString(white.toArray()));
//        System.out.print(ANSI_RESET);
//        System.out.print("Black: ");
//        System.out.print(ANSI_YELLOW);
//        System.out.println(Arrays.toString(black.toArray()));
//        System.out.print(ANSI_RESET);
//
//    }
}
