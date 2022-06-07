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

public class ContactSolutionTests {

    @Test
    public void case1() throws IOException {
        String input = "4\n" + "add hack\n" + "add hackerrank\n" + "find hac\n" + "find hak\n";
        String expected = "2\n" + "0\n";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(Collectors.toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();

        List<Integer> result = Solutions.contacts(queries);
        Assert.assertEquals(expected, result.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n");
    }
}
