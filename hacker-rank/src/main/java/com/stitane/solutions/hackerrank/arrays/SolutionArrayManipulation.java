package com.stitane.solutions.hackerrank.arrays;

public class SolutionArrayManipulation {

    private SolutionArrayManipulation() {
    }

    static void update(long[] arrayD, int l, int r, long x) {
        arrayD[l] += x;
        arrayD[r + 1] -= x;
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long[] arrayD = new long[n + 1];
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            long k = query[2];
            update(arrayD, a, b, k);
        }
        return getMaxValue(array, arrayD);
    }

    private static long getMaxValue(long[] array, long[] arrayD) {
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = arrayD[i];
            } else {
                array[i] = arrayD[i] + array[i - 1];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
