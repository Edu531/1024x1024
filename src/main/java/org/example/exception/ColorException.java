package org.example.exception;

import java.io.Serial;

public class ColorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ColorException(String message) {
        super(message);
    }
}
