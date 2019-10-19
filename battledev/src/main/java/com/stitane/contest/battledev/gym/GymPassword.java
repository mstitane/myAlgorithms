package com.stitane.contest.battledev.gym;

import java.util.Scanner;

public class GymPassword {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());

            if (a % d == 0) {
                System.out.println(a);
            }

            if (b % d == 0) {
                System.out.println(b);
            }

            for (int i = a + 1; i < b; i++) {
                if (i % d == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}