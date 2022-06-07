package com.stitane.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.stitane.solutions.hackerrank.arrays.Solutions;
import org.junit.Assert;
import org.junit.Test;

public class RunningMedianTests {

    @Test
    public void case1() throws IOException {
        String input = "10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9\n" + "10\n";
        String expected = "1.0\n" + "1.5\n" + "2.0\n" + "2.5\n" + "3.0\n" + "3.5\n" + "4.0\n" + "4.5\n" + "5.0\n" + "5.5\n";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        bufferedReader.close();

        List<Double> result = Solutions.runningMedian(a);

        Assert.assertEquals(expected, result.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n");
    }
}
