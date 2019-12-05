package com.stitane.solutions.hackerrank.arrays;

import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionArrayManipulationTest {

    @Test
    public void testShouldReturn200() {
        String input = "5 3\n" + "1 2 100\n" + "2 5 100\n" + "3 4 100";
        Scanner scanner = new Scanner(input);
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = SolutionArrayManipulation.arrayManipulation(n, queries);
        assertEquals(200, result);
    }

    @Test
    public void testShouldReturn7542539201() {
        long expected = 7542539201L;
        Scanner scanner = new Scanner(getClass().getResourceAsStream("/arrays/input04.txt"));
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = SolutionArrayManipulation.arrayManipulation(n, queries);
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturn2497169732() {
        long expected = 2497169732L;
        Scanner scanner = new Scanner(getClass().getResourceAsStream("/arrays/input07.txt"));
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = SolutionArrayManipulation.arrayManipulation(n, queries);
        assertEquals(expected, result);
    }
}