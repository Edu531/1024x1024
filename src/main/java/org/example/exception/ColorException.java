package org.example.exception;

import java.io.Serial;

public class ColorException extends GameException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ColorException(String message) {
        super(message);
    }
}
