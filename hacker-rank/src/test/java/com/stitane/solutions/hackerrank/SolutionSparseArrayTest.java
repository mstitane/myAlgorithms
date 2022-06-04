package com.stitane.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.IntStream;

import com.stitane.solutions.hackerrank.arrays.Solutions;
import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SolutionSparseArrayTest {

    @Test
    public void test1() throws IOException {
        String expected = "2\n1\n0\n";
        String inputStrings = "4\naba\nbaba\naba\nxzxb\n3\naba\nxzxb\nab";
        String inputQueries = "3\naba\nxzxb\nab";
        List<String> strings = getStrings(inputStrings);
        List<String> queries = getStrings(inputQueries);

        List<Integer> res = Solutions.matchingStrings(strings, queries);

        String result = res.stream().map(Object::toString).collect(joining("\n")) + "\n";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void test2() throws IOException {
        String expected = "1\n0\n1\n";
        String inputStrings = "3\ndef\nde\nfgh\n";
        String inputQueries = "3\nde\nlmn\nfgh";
        List<String> strings = getStrings(inputStrings);
        List<String> queries = getStrings(inputQueries);

        List<Integer> res = Solutions.matchingStrings(strings, queries);

        String result = res.stream().map(Object::toString).collect(joining("\n")) + "\n";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void test3() throws IOException {
        String expected = "1\n3\n4\n3\n2\n";
        String inputStrings = "13\nabcde\nsdaklfj\nasdjf\nna\nbasdn\nsdaklfj\nasdjf\nna\nasdjf\nna\nbasdn\nsdaklfj\nasdjf\n";
        String inputQueries = "5\nabcde\nsdaklfj\nasdjf\nna\nbasdn";
        List<String> strings = getStrings(inputStrings);
        List<String> queries = getStrings(inputQueries);
        List<Integer> res = Solutions.matchingStrings(strings, queries);
        String result = res.stream().map(Object::toString).collect(joining("\n")) + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test4() throws IOException {
        String expected = "9\n8\n16\n10\n9\n10\n9\n14\n8\n10\n4\n10\n9\n9\n16\n10\n10\n9\n" + "9\n4\n14\n8\n9\n4\n10\n14\n8\n9\n9\n10\n14\n9\n14\n4\n9\n14\n8\n"
                + "10\n8\n14\n16\n14\n10\n9\n8\n8\n10\n10\n10\n11\n9\n14\n9\n9\n8\n14\n" + "9\n9\n9\n10\n8\n11\n10\n9\n10\n8\n9\n9\n10\n10\n9\n9\n9\n9\n10\n"
                + "16\n8\n11\n10\n14\n10\n8\n11\n11\n9\n14\n9\n8\n9\n10\n8\n10\n16\n11\n" + "11\n8\n8\n10\n4\n8\n";
        String inputStrings = "100\nlekgdisnsbfdzpqlkg\neagemhdygyv\njwvwwnrhuai\nurcadmrwlqe\nmpgqsvxrijpombyv\nmpgqsvxrijpombyv\nurcadmrwlqe\n"
                + "mpgqsvxrijpombyv\neagemhdygyv\neagemhdygyv\njwvwwnrhuai\nurcadmrwlqe\njwvwwnrhuai\nkvugevicpsdf\nkvugevicpsdf\n"
                + "mpgqsvxrijpombyv\nurcadmrwlqe\nmpgqsvxrijpombyv\nexdafbnobg\nqhootohpnfvbl\nsuffrbmqgnln\nexdafbnobg\nexdafbnobg\n"
                + "eagemhdygyv\nmpgqsvxrijpombyv\nurcadmrwlqe\njwvwwnrhuai\nlekgdisnsbfdzpqlkg\nmpgqsvxrijpombyv\nlekgdisnsbfdzpqlkg\n"
                + "jwvwwnrhuai\nexdafbnobg\nmpgqsvxrijpombyv\nkvugevicpsdf\nqhootohpnfvbl\nurcadmrwlqe\nkvugevicpsdf\nmpgqsvxrijpombyv\n"
                + "lekgdisnsbfdzpqlkg\nmpgqsvxrijpombyv\nkvugevicpsdf\nqhootohpnfvbl\nlxyqetmgdbmh\nurcadmrwlqe\nurcadmrwlqe\n"
                + "kvugevicpsdf\nlxyqetmgdbmh\nurcadmrwlqe\nlxyqetmgdbmh\njwvwwnrhuai\nqhootohpnfvbl\nqhootohpnfvbl\njwvwwnrhuai\n"
                + "lekgdisnsbfdzpqlkg\nkvugevicpsdf\nmpgqsvxrijpombyv\nexdafbnobg\nkvugevicpsdf\nlekgdisnsbfdzpqlkg\nqhootohpnfvbl\n"
                + "exdafbnobg\nqhootohpnfvbl\nexdafbnobg\nmpgqsvxrijpombyv\nsuffrbmqgnln\nmpgqsvxrijpombyv\nqhootohpnfvbl\njwvwwnrhuai\n"
                + "mpgqsvxrijpombyv\nqhootohpnfvbl\nlekgdisnsbfdzpqlkg\neagemhdygyv\njwvwwnrhuai\nkvugevicpsdf\neagemhdygyv\n"
                + "eagemhdygyv\nlxyqetmgdbmh\nqhootohpnfvbl\nlxyqetmgdbmh\nexdafbnobg\nqhootohpnfvbl\nqhootohpnfvbl\nexdafbnobg\n"
                + "suffrbmqgnln\nmpgqsvxrijpombyv\nurcadmrwlqe\neagemhdygyv\nlxyqetmgdbmh\nurcadmrwlqe\nsuffrbmqgnln\nqhootohpnfvbl\n"
                + "kvugevicpsdf\nlekgdisnsbfdzpqlkg\nlxyqetmgdbmh\nmpgqsvxrijpombyv\njwvwwnrhuai\nlxyqetmgdbmh\nlxyqetmgdbmh\n" + "lekgdisnsbfdzpqlkg\nqhootohpnfvbl";
        String inputQueries = "100\nexdafbnobg\neagemhdygyv\nmpgqsvxrijpombyv\nkvugevicpsdf\nlekgdisnsbfdzpqlkg\nkvugevicpsdf\nexdafbnobg\n"
                + "qhootohpnfvbl\neagemhdygyv\nkvugevicpsdf\nsuffrbmqgnln\njwvwwnrhuai\nlekgdisnsbfdzpqlkg\nlekgdisnsbfdzpqlkg\n"
                + "mpgqsvxrijpombyv\njwvwwnrhuai\nkvugevicpsdf\nlekgdisnsbfdzpqlkg\nexdafbnobg\nsuffrbmqgnln\nqhootohpnfvbl\neagemhdygyv\n"
                + "exdafbnobg\nsuffrbmqgnln\njwvwwnrhuai\nqhootohpnfvbl\neagemhdygyv\nexdafbnobg\nexdafbnobg\njwvwwnrhuai\nqhootohpnfvbl\n"
                + "lxyqetmgdbmh\nqhootohpnfvbl\nsuffrbmqgnln\nlxyqetmgdbmh\nqhootohpnfvbl\neagemhdygyv\njwvwwnrhuai\neagemhdygyv\n"
                + "qhootohpnfvbl\nmpgqsvxrijpombyv\nqhootohpnfvbl\njwvwwnrhuai\nexdafbnobg\neagemhdygyv\neagemhdygyv\nkvugevicpsdf\n"
                + "kvugevicpsdf\njwvwwnrhuai\nurcadmrwlqe\nlxyqetmgdbmh\nqhootohpnfvbl\nexdafbnobg\nexdafbnobg\neagemhdygyv\n"
                + "qhootohpnfvbl\nexdafbnobg\nexdafbnobg\nlekgdisnsbfdzpqlkg\njwvwwnrhuai\neagemhdygyv\nurcadmrwlqe\nkvugevicpsdf\n"
                + "lekgdisnsbfdzpqlkg\njwvwwnrhuai\neagemhdygyv\nlekgdisnsbfdzpqlkg\nexdafbnobg\nkvugevicpsdf\njwvwwnrhuai\nexdafbnobg\n"
                + "lxyqetmgdbmh\nexdafbnobg\nlxyqetmgdbmh\njwvwwnrhuai\nmpgqsvxrijpombyv\neagemhdygyv\nurcadmrwlqe\nkvugevicpsdf\n"
                + "qhootohpnfvbl\njwvwwnrhuai\neagemhdygyv\nurcadmrwlqe\nurcadmrwlqe\nexdafbnobg\nqhootohpnfvbl\nexdafbnobg\neagemhdygyv\n"
                + "exdafbnobg\njwvwwnrhuai\neagemhdygyv\njwvwwnrhuai\nmpgqsvxrijpombyv\nurcadmrwlqe\nurcadmrwlqe\neagemhdygyv\n"
                + "eagemhdygyv\njwvwwnrhuai\nsuffrbmqgnln\neagemhdygyv";
        List<String> strings = getStrings(inputStrings);
        List<String> queries = getStrings(inputQueries);

        List<Integer> res = Solutions.matchingStrings(strings, queries);

        String result = res.stream().map(Object::toString).collect(joining("\n")) + "\n";

        Assert.assertEquals(expected, result);
    }

    private List<String> getStrings(String input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        return IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());
    }
}
