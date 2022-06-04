package com.stitane.solutions.hackerrank.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class QueueSolutionTests {

    @Test
    public void basic_queue_operation_case1() {
        String input = "5\n" + "1 4\n" + "1 9\n" + "3\n" + "2 4\n" + "3";
        String result = QueueSolution.basicQueueOperation(input);

        String expected = "4\n" + "9\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void using_two_stacks_case1() {
        String input = "10\n" + "1 42\n" + "2\n" + "1 14\n" + "3\n" + "1 28\n" + "3\n" + "1 60\n" + "1 78\n" + "2\n" + "2\n";
        String result = QueueSolution.queueUsingTwoStacks(input);

        String expected = "14\n" + "14\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void cookies_case1() throws IOException {
        String input = "6 7\n" + "1 2 3 9 10 12";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        bufferedReader.close();

        int result = QueueSolution.cookies(k, A);
        Assert.assertEquals(2, result);
    }
}
