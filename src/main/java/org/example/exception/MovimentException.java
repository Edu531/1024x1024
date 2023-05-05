package org.example.exception;

import java.io.Serial;

public class MovimentException extends GameException {
    @Serial
    private static final long serialVersionUID = 1L;

    public MovimentException(String message) {
        super(message);
    }
}
