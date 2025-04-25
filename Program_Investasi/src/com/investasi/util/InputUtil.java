package com.investasi.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int inputInt(String prompt) {
        int val;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                val = scanner.nextInt();
                scanner.nextLine(); 
                return val;
            } else {
                System.out.println("Masukkan angka yang valid!");
                scanner.nextLine(); 
            }
        }
    }

    public static double inputDouble(String prompt) {
        double val;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                val = scanner.nextDouble();
                scanner.nextLine(); 
                return val;
            } else {
                System.out.println("Masukkan angka desimal yang valid!");
                scanner.nextLine(); 
            }
        }
    }
}
