package com.stitane.solutions.hackerrank.arrays;

import java.util.stream.IntStream;

public class SolutionArrayManipulation {

    private SolutionArrayManipulation() {
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        final long[] max = { 0 };
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            long k = query[2];
            IntStream.rangeClosed(a, b).forEach(i -> {
            long plus = array[i] + k;
            array[i] = plus;
            if (plus > max[0])
                max[0] = plus;
            });
        }
        return max[0];
    }
}
