package org.example.application;

import org.example.exception.GameException;

import java.util.Scanner;

public class Program {
    private Program() {
    }

    public static void start() {
        final Scanner scanner = new Scanner(System.in);
        final GameMatch gameMatch = new GameMatch(scanner);

        gameMatch.startMatch();

        while (!gameMatch.isGameOver()) {
            try {
                gameMatch.startRound();
            } catch (GameException e) {
                gameMatch.printError(e.getMessage());
            }
        }
        gameMatch.printGameOver();

        scanner.close();
    }
}
