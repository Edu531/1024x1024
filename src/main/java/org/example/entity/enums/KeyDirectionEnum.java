package org.example.entity.enums;

import java.util.Optional;

public enum KeyDirectionEnum {
    UP("W"),
    DOWN("S"),
    LEFT("A"),
    RIGHT("D");

    private final String key;

    KeyDirectionEnum(String key) {
        this.key = key;
    }

    public static Optional<KeyDirectionEnum> getByKeyCode(String key) {
        for (KeyDirectionEnum keyDirectionEnum : KeyDirectionEnum.values()) {
            if (keyDirectionEnum.getKey().equalsIgnoreCase(key)) {
                return Optional.of(keyDirectionEnum);
            }
        }
        return Optional.empty();
    }

    public String getKey() {
        return key;
    }
}
