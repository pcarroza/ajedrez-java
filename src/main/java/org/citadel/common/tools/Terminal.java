package org.citadel.common.tools;

import java.util.Scanner;

public class Terminal {

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

    public static <T> T input(Class<T> type) {
        assert type != null;
        Scanner scanner = new Scanner(System.in);
        boolean ok = false;
        T value = null;
        do {
            try {
                if (type == Integer.class) {
                    value = type.cast(scanner.nextInt());
                    ok = true;
                } else if (type == Double.class) {
                    value = type.cast(scanner.nextDouble());
                    ok = true;
                } else if (type == String.class) {
                    value = type.cast(scanner.nextLine());
                    ok = true;
                } else {
                    writeln("TIPO NO ENCONTRADO");
                    assert true;
                }
            } catch (Exception e) {
                writeln("Valor inválido. Intente de nuevo.");
            }
        } while (!ok);
        return value;
    }
}
