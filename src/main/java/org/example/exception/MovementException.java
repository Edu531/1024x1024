package org.example.exception;

import java.io.Serial;

public class MovementException extends GameException {
    @Serial
    private static final long serialVersionUID = 1L;

    public MovementException(String message) {
        super(message);
    }
}
