package org.example.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Program {
    static final Logger logger = LogManager.getLogger(Program.class);
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
                logger.error(e.getMessage());
            }
        }

        scanner.close();
    }
}
