package com.stitane.solutions.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalSquare {

    private DiagonalSquare() {
    }

    static List<Long> divided(List<List<Long>> arr) {
        long p1 = getSumP1(arr);
        long p2 = getSumP2(arr);
        long p3 = getSumP3(arr);
        long p4 = getSumP4(arr);
        return Arrays.asList(p1, p2, p3, p4);
    }

    private static long getSumP4(List<List<Long>> arr) {
        int len = arr.size();
        int sum = 0;
        int start= len / 2;
        int end = start + 1;
        for (int j = 1 + len / 2; j < len; j++) {
            List<Long> row = arr.get(j);
            sum += IntStream.range(start, end).mapToObj(row::get).mapToLong(col -> col).sum();
            start--;
            end++;
        }
        return sum;
    }

    private static long getSumP3(List<List<Long>> arr) {
        long sum = 0;
        int end;
        int start = end = arr.size();
        for (int j = 1; j < arr.size() - 1; j++) {
            List<Long> row = arr.get(j);
            if (j > (arr.size() - 1) / 2) {
                start++;
            } else {
                start--;
            }
            sum += IntStream.range(start, end).mapToObj(row::get).mapToLong(col -> col).sum();
        }
        return sum;
    }

    private static long getSumP2(List<List<Long>> arr) {
        int len = arr.size() - 1;
        long sum = 0;
        int start = 1;
        int end = 0;
        for (int j = start; j < len; j++) {
            List<Long> row = arr.get(j);
            if (j > (len) / 2) {
                end--;
            } else {
                end++;
            }
            sum += IntStream.range(0, end).mapToObj(row::get).mapToLong(col -> col).sum();

        }
        return sum;
    }

    private static long getSumP1(List<List<Long>> arr) {
        int len = arr.size() - 1;
        int sum = 0;
        int start = 1;
        int end = len;
        for (int j = 0; j < (len / 2); j++) {
            List<Long> row = arr.get(j);
            sum += IntStream.range(start, end).mapToObj(row::get).mapToLong(col -> col).sum();
            start++;
            end--;
        }
        return sum;
    }
}