package com.stchool.ecommerce.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String message) {
        System.out.println(message);
        int integerInput = scanner.nextInt();
        scanner.nextLine();
        return integerInput;
    }

    public static String getStringInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static char getCharInput(String message) {
        System.out.println(message);
        return scanner.next().charAt(0);
    }

    public static float getFloatInput(String message) {
        System.out.println(message);
        return scanner.nextFloat();
    }

    public static double getDoubleInput(String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
