package org.example.application;

import org.example.entity.Board;
import org.example.entity.enums.AnsiColorEnum;
import org.example.entity.enums.KeyDirectionEnum;
import org.example.exception.ColorException;
import org.example.exception.KeyException;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

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
        UI.println("Type the key to move the pieces (W, A, S, D): ", AnsiColorEnum.ANSI_GREEN);
        return KeyDirectionEnum.getByKeyCode(scanner.next()).orElseThrow(() -> new KeyException("Invalid key"));
    }

    public static void printMatch(Board board) {
        printTable(board.getTable());
        println("");
    }

    private static void printTable(Integer[][] table) {
        printTopSpace();
        String space = getCorrectSpace(table);

        for (int i = 0; i < table.length; i++) {
            print((table.length - i) + " ");
            for (Integer piece : table[i]) {
                if (Objects.nonNull(piece) && piece.toString().length() != 1) {
                    printPiece(piece, "", false);
                    int tamanho = space.length() - piece.toString().length();
                    print(Stream.generate(() -> " ").limit(tamanho).reduce((s1, s2) -> s1 + s2).orElse(" "));
                } else {
                    printPiece(piece, space, false);
                }
            }
            println("");
        }
        println(String.format("  a%sb%sc%sd", space, space, space));
    }

    private static void printPiece(Integer piece, String space, boolean background) {
        if (background) {
            print("", AnsiColorEnum.ANSI_BLUE_BACKGROUND);
        }
        if (Objects.isNull(piece)) {
            print("-");
        } else {
            print(piece.toString(), AnsiColorEnum.ANSI_YELLOW);
        }
        print(space);
    }

    private static String getCorrectSpace(Integer[][] table) {
        int tamanho = 0;
        for (Integer[] row : table) {
            for (Integer piece : row) {
                if (Objects.nonNull(piece)) {
                    tamanho = Math.max(tamanho, piece.toString().length());
                }
            }
        }
        return Stream.generate(() -> " ").limit(tamanho).reduce((s1, s2) -> s1 + s2).orElse("");
    }

    public static void printGameOver(Board board) {
        clearScreen();
        printMatch(board);
        println("Game Over!", AnsiColorEnum.ANSI_RED);
    }

    public static void printError(String message, Scanner scanner) {
        println(message, AnsiColorEnum.ANSI_RED);
        println("");
        println("Press enter to continue", AnsiColorEnum.ANSI_GREEN);
        scanner.nextLine();
    }

    public static void startMatch(Scanner scanner) {
        println("###############", AnsiColorEnum.ANSI_GREEN);
        println("## 1024x1024 ##", AnsiColorEnum.ANSI_GREEN);
        println("###############", AnsiColorEnum.ANSI_GREEN);
        println("");
        println("Press enter to start", AnsiColorEnum.ANSI_GREEN);
        scanner.nextLine();
    }

    private static void printTopSpace() {
        println("");
        println("");
    }
}
