package org.example.application;

import java.util.Scanner;

public class Program {
    private Program() {
    }

    public static void start() {
        final Scanner scanner = new Scanner(System.in);
        final GameMatch gameMatch = new GameMatch();

        gameMatch.startMatch(scanner);

        while (!gameMatch.isGameOver()) {
            try {
                gameMatch.startRound();
            } catch (Exception e) {
                UI.println(e.getMessage());
            }
        }
        gameMatch.printGameOver();

        scanner.close();
    }
}
