package com.stitane.solutions.hackerrank.arrays;

import java.util.stream.LongStream;
import java.util.stream.IntStream;

public class SolutionArrayManipulation {

    private SolutionArrayManipulation() {
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            long k = query[2];
            IntStream.rangeClosed(a, b).forEach(i -> array[i] = array[i] + k);
        }
        return LongStream.of(array).max().orElse(0);
    }
}
