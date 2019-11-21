package com.stitane.solutions.hackerrank.arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import static com.stitane.solutions.hackerrank.arrays.Solution.rotLeft;

public class SolutionRotateLeftTest {

    @Test
    public void test() throws IOException {
        int[] expected = { 5, 1, 2, 3, 4 };
        String in = "5 4\n" + "1 2 3 4 5";
        Scanner scanner = new Scanner(in);
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(result, expected);
    }
}
