package com.stitane.solutions.hackerrank.arrays;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private Solution() {
    }

    public static void plusMinus(int[] arr) {
        int countPositives = 0;
        int countNegatives = 0;
        int countZero = 0;
        for (int i : arr) {
            if (i > 0) {
                countPositives++;
            } else if (i < 0) {
                countNegatives++;
            } else
                countZero++;
        }
        System.out.println(BigDecimal.valueOf((double) countPositives / arr.length).setScale(6, RoundingMode.CEILING));
        System.out.println(BigDecimal.valueOf((double) countNegatives / arr.length).setScale(6, RoundingMode.CEILING));
        System.out.println(BigDecimal.valueOf((double) countZero / arr.length).setScale(6, RoundingMode.CEILING));
    }

    // Complete the staircase function below.
    public static void staircase(int n) {
        int m = n - 1;
        for (int i = 0; i < n; i++) {
            String s = String.join("", Collections.nCopies(m, " "));
            String p = String.join("", Collections.nCopies(n - m, "#"));
            System.out.println(s + p);
            m--;
        }
    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minSum = IntStream.of(arr).sorted().limit(4).mapToLong(i -> i).sum();
        long maxSum = IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).limit(4).mapToLong(i -> i).sum();
        System.out.print(minSum + " " + maxSum);
    }

    static void currencyCode() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        String india = currencyInstance.format(payment).replace("$", "Rs.");
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        out.println("US: " + us);
        out.println("India: " + india);
        out.println("China: " + china);
        out.println("France: " + france);
        out.close();
    }

    static void hourglassSum(int[][] arr) {
        Set<Integer> sum = new HashSet<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
            }
        }

        sum.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }

    static int[] rotLeft(int[] a, int d) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        Collections.rotate(list, a.length - d);

        return list.stream().mapToInt(i -> i).toArray();
    }

}