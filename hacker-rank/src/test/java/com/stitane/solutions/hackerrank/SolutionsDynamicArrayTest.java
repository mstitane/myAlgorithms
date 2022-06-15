package com.stitane.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.stitane.solutions.hackerrank.arrays.Solutions;
import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class SolutionsDynamicArrayTest {

    @Test
    public void dynamic_array_test() throws IOException {
        int[] expected = { 7, 3 };
        String in = "2 5\n" + "1 0 5\n" + "1 1 7\n" + "1 0 3\n" + "2 1 0\n" + "2 1 1";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Solutions.dynamicArray(n, queries);

        Assert.assertArrayEquals(expected, result.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void maximum_element_test1() throws IOException {
        String in = "10\n" + "1 97\n" + "2\n" + "1 20\n" + "2\n" + "1 26\n" + "1 20\n" + "2\n" + "3\n" + "1 91\n" + "3\n";
        String expected = "26\n" + "91\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        bufferedReader.close();
        List<Integer> res = Solutions.getMax(ops);

        String result = res.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void maximum_element_test2() throws IOException {
        String in = "68\n" + "1 1\n" + "1 44\n" + "3\n" + "3\n" + "2\n" + "3\n" + "3\n" + "1 3\n" + "1 37\n" + "2\n" + "3\n" + "1 29\n" + "3\n" + "1 73\n" + "1 51\n" + "3\n"
                + "3\n" + "3\n" + "1 70\n" + "3\n" + "1 8\n" + "2\n" + "1 49\n" + "1 56\n" + "1 81\n" + "2\n" + "1 59\n" + "1 44\n" + "2\n" + "3\n" + "3\n" + "2\n" + "3\n" + "3\n"
                + "1 4\n" + "3\n" + "1 89\n" + "2\n" + "1 37\n" + "1 50\n" + "1 64\n" + "2\n" + "1 49\n" + "1 35\n" + "1 85\n" + "3\n" + "1 41\n" + "2\n" + "3\n" + "3\n" + "1 86\n"
                + "3\n" + "1 60\n" + "1 8\n" + "3\n" + "1 100\n" + "3\n" + "1 83\n" + "3\n" + "1 47\n" + "2\n" + "1 78\n" + "2\n" + "1 55\n" + "1 97\n" + "2\n" + "3\n" + "1 40\n";
        String expected = "44\n" + "44\n" + "1\n" + "1\n" + "3\n" + "29\n" + "73\n" + "73\n" + "73\n" + "73\n" + "73\n" + "73\n" + "73\n" + "73\n" + "73\n" + "85\n" + "85\n"
                + "85\n" + "86\n" + "86\n" + "100\n" + "100\n" + "100\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        bufferedReader.close();
        List<Integer> res = Solutions.getMax(ops);

        String result = res.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n";
        Assert.assertEquals(expected, result);
    }
}
