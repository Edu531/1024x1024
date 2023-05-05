package org.example.exception;

import java.io.Serial;

public class GameException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public GameException(String message) {
        super(message);
    }
}
