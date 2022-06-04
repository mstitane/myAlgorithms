package com.stitane.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.stitane.solutions.hackerrank.arrays.Solutions;
import com.stitane.solutions.hackerrank.java_braces.Parser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionsTest {

    @Test
    public void plusMinus() {
        String result = Solutions.plusMinus(new int[] { 1, 2 });
        Assert.assertEquals("1.000000\n" + "0.000000\n" + "0.000000\n", result);
    }

    @Test
    public void staircase() {
        String result = Solutions.staircase(6);
        Assert.assertEquals("     #\n" + "    ##\n" + "   ###\n" + "  ####\n" + " #####\n" + "######\n", result);
    }

    @Test
    public void min_max_test_case1() throws IOException {
        String input = "7\n" + "3\n" + "10\n" + "100\n" + "300\n" + "200\n" + "1000\n" + "20\n" + "30\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        bufferedReader.close();
        int result = Solutions.minMaxSum(k, arr);
        Assert.assertEquals(20, result);
    }

    @Test
    public void min_max_test_case2() throws IOException {
        String input = "20\n" + "5\n" + "4504\n" + "1520\n" + "5857\n" + "4094\n" + "4157\n" + "3902\n" + "822\n" + "6643\n" + "2422\n" + "7288\n" + "8245\n" + "9948\n" + "2822\n"
                + "1784\n" + "7802\n" + "3142\n" + "9739\n" + "5629\n" + "5413\n" + "7232\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        bufferedReader.close();
        int result = Solutions.minMaxSum(k, arr);
        Assert.assertEquals(1335, result);
    }

    @Test
    public void currency_code_test_case() {
        String result = Solutions.currencyCode(12324.134);
        Assert.assertEquals("US: $12,324.13\n" + "India: Rs.12,324.13\n" + "China: ￥12,324.13\n" + "France: 12 324,13 €\n", result);
    }

    @Test
    public void case1() {
        String input = "{[()]}\n" + "{[(])}\n" + "{{[[(())]]}}";
        Scanner in = new Scanner(new StringReader(input));

        StringBuilder out = new StringBuilder();
        while (in.hasNext()) {
            out.append(Parser.isBalanced(in.next())).append("\n");
        }

        in.close();

        String expected = "YES\n" + "NO\n" + "YES\n";
        assertEquals(expected, out.toString());
    }
}