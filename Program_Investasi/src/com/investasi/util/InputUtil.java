package com.investasi.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Masukkan angka yang valid!");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double inputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Masukkan angka desimal yang valid!");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextDouble();

    }
}
