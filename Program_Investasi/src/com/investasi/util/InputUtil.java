package com.investasi.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String prompt) {
        String result;
        do {
            System.out.print(prompt);
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        } while (result.isEmpty());
        return result;
    }

    public static String authNotEmpty(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Identitas tidak boleh kosong!");
            }
        } while (value.isEmpty());
        return value;
    }

    public static int inputInt(String prompt) {
        int val;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue;
            }
            try {
                val = Integer.parseInt(input);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka bulat yang valid!");
            }
        }
    }

    public static double inputDouble(String prompt) {
        double val;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue;
            }
            try {
                val = Double.parseDouble(input);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka desimal yang valid!");
            }
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal clear layar.");
        }
    }

    public static void pause() {
        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }    
}
