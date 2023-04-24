package org.example.entity.enums;

import java.awt.event.KeyEvent;
import java.util.Optional;

public enum KeyDirectionEnum {
    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN),
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT);

    private final int keyEvent;

    KeyDirectionEnum(int keyEvent) {
        this.keyEvent = keyEvent;
    }

    public static Optional<KeyDirectionEnum> getByKeyCode(int keyCode) {
        for (KeyDirectionEnum keyDirectionEnum : KeyDirectionEnum.values()) {
            if (keyDirectionEnum.getKeyEvent() == keyCode) {
                return Optional.of(keyDirectionEnum);
            }
        }
        return Optional.empty();
    }

    public int getKeyEvent() {
        return keyEvent;
    }
}
