package com.stitane.contest.battledev.tickets;

import java.util.Scanner;

public class TicketsContest {
    // FIXME not work yet
    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (sc.hasNextLine()) {
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                int anInt = Integer.parseInt(line.trim());
                if (anInt > 99) {
                    char[] chars = line.toCharArray();
                    int sum = 0;
                    for (char c : chars) {
                        sum += Integer.parseInt(c + "");
                    }
                    System.err.println(i + "-line =" + line + " sum=" + sum);
                    if (sum == 42) {
                        count++;
                    }
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}