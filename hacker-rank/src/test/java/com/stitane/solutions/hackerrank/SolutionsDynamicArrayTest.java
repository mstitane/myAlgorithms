package com.stitane.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.stitane.solutions.hackerrank.dynamic_array.Result;
import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class SolutionsDynamicArrayTest {

    @Test
    public void test() throws IOException {
        int[] expected = { 7, 3};
        String in = "2 5\n" + "1 0 5\n" + "1 1 7\n" + "1 0 3\n" + "2 1 0\n" + "2 1 1";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(in));
        // Set the standard output to use newConsole.
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(consoleOut));

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

        List<Integer> result = Result.dynamicArray(n, queries);

        Assert.assertArrayEquals(expected, result.stream().mapToInt(Integer::intValue).toArray());
    }
}
