package model;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import static java.awt.event.KeyEvent.*;

public enum Direction {
    UP(VK_UP),
    LEFT(VK_LEFT),
    DOWN(VK_DOWN),
    RIGHT(VK_DOWN);

    int code;

    Direction(int code) {
        this.code = code;
    }

    public static boolean isValid(int code) {
        return Arrays.stream(values()).anyMatch(elem -> elem.code == code);
    }
}
