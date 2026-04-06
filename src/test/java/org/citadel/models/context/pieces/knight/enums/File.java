package org.citadel.models.context.pieces.knight.enums;

public enum File {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int column;

    File(int column) {
        this.column = column;
    }

    public int column() {
        return column;
    }

    public static File from(int column) {
        for (File file : values()) {
            if (file.column == column) {
                return file;
            }
        }
        return null;
    }

    public static File from(char c) {
        return File.valueOf(String.valueOf(c));
    }

    public char chatAt() {
        return name().charAt(0);
    }
}