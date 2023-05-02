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
        UI.println("Digite a tecla para mover as peças (W, A, S, D): ", AnsiColorEnum.ANSI_GREEN);
        return KeyDirectionEnum.getByKeyCode(scanner.next()).orElseThrow(() -> new KeyException("Tecla inválida"));
    }

    public static void printMatch(Board board) {
        printTable(board.getTable());
        println("");
    }


    private static void printTable(Integer[][] table) {
        for (int i = 0; i < table.length; i++) {
            print((table.length - i) + " ");
            for (int j = 0; j < table[i].length; j++) {
                printPiece(table[i][j], false);
            }
            println("");
        }
        println("  a b c d");
    }

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
}
