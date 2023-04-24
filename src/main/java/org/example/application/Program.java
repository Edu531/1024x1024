package org.example.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Program {
    static final Logger logger = LogManager.getLogger(Program.class);

    private Program() {
    }

    public static void start() {
        GameMatch gameMatch = new GameMatch();

        gameMatch.startMatch();

//        while (gameMatch.canMove()) {
//            try {
//
//            } catch () {
//
//            } catch () {
//
//            } finally {
//
//            }
//        }
    }
}
