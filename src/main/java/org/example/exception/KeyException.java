package org.example.exception;

import java.io.Serial;

public class KeyException extends GameException {
    @Serial
    private static final long serialVersionUID = 1L;

    public KeyException(String message) {
        super(message);
    }
}
