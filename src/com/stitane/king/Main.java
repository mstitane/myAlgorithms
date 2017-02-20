package com.stitane.king;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong(), b = sc.nextLong();
            System.out.println(getsDifference(a,b));
        }
        sc.close();
    }

    private static long getsDifference(long a, long b) {
        return Math.abs(a - b);
    }
}
