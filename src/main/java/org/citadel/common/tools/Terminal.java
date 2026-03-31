package org.citadel.common.tools;

import java.util.Scanner;

public class Terminal {

    private static final Scanner scanner = new Scanner(System.in);

    private Terminal() {
    }

    public static void writeln(String message) {
        System.out.println(message);
    }

    public static void writeln(boolean value) {
        System.out.println(value);
    }

    public static void write(String message) {
        System.out.print(message);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static <T> T input(Class<T> type) {
        assert type != null;
        boolean ok = false;
        T value = null;
        do {
            try {
                if (type == Integer.class) {
                    value = type.cast(Integer.parseInt(scanner.nextLine()));
                    ok = true;
                } else if (type == Double.class) {
                    value = type.cast(Double.parseDouble(scanner.nextLine()));
                    ok = true;
                } else if (type == String.class) {
                    value = type.cast(scanner.nextLine());
                    ok = true;
                } else {
                    writeln("TIPO NO ENCONTRADO");
                    assert false;
                }
            } catch (Exception e) {
                writeln("Valor inválido. Intente de nuevo.");
            }
        } while (!ok);
        return value;
    }

    public static int readInt(String message) {
        write(message);
        return input(Integer.class);
    }

    public static String readString(String message) {
        write(message);
        return input(String.class);
    }
}
