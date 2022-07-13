package com.stitane.solutions.hackerrank.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    public void waiter_case0() throws IOException {
        String input = "5 1\n3 4 7 6 5";
        String expected = "4\n6\n3\n7\n5";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        bufferedReader.close();

        List<Integer> result = QueueSolution.waiter(A, k);
        String actual = result.stream().map(Object::toString).collect(Collectors.joining("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void waiter_case1() throws IOException {
        String input = "5 2\n3 3 4 4 9";
        String expected = "4\n4\n9\n3\n3";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        bufferedReader.close();

        List<Integer> result = QueueSolution.waiter(A, k);
        String actual = result.stream().map(Object::toString).collect(Collectors.joining("\n"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void waiter_case2() throws IOException {
        String input = "47 21\n" + "80 37 86 79 8 39 43 41 15 33 30 15 45 55 61 74 49 49 20 66 77 19 85 44 81 82 27 5 36 83 91 45 39 44 19 44 71 49 8 66 81 40 29 60 35 31 44";
        String expected = "80\n86\n8\n30\n74\n20\n66\n44\n82\n36\n44\n44\n8\n66\n40\n60\n44\n"
                + "81\n39\n45\n27\n81\n45\n15\n33\n15\n39\n55\n85\n5\n35\n49\n91\n77\n49\n"
                + "49\n19\n19\n29\n31\n37\n41\n43\n61\n71\n79\n83";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        bufferedReader.close();

        List<Integer> result = QueueSolution.waiter(A, k);
        String actual = result.stream().map(Object::toString).collect(Collectors.joining("\n"));
        Assert.assertEquals(expected, actual);
    }
}
