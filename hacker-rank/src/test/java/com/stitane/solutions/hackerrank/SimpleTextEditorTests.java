package com.stitane.solutions.hackerrank;

import java.io.StringReader;
import java.util.Scanner;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem?isFullScreen=true
 */
public class SimpleTextEditorTests {
    @Test
    public void case1() {
        SimpleTextEditor simpleTextEditor = new SimpleTextEditor();
        String input = "8\n" + "1 abc\n" + "3 3\n" + "2 3\n" + "1 xy\n" + "3 2\n" + "4\n" + "4\n" + "3 1\n";
        String expected = "c\ny\na\n";
        StringBuilder out = new StringBuilder();
        Scanner scanner = new Scanner(new StringReader(input));
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            simpleTextEditor.performOperation(out, line);
        }

        Assertions.assertEquals(expected, out.toString());
    }

    @Test
    public void case2() {
        SimpleTextEditor simpleTextEditor = new SimpleTextEditor();
        String input = "10\n" + "1 ewcgpjfh\n" + "1 igqsbqyp\n" + "1 qsdliigcj\n" + "4\n" + "3 15\n" + "1 iilmgp\n" + "2 8\n" + "4\n" + "2 18\n" + "1 scwhors";
        String expected = "y\n";
        StringBuilder out = new StringBuilder();
        Scanner scanner = new Scanner(new StringReader(input));
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            simpleTextEditor.performOperation(out, line);
            System.out.println(line + "===> " + simpleTextEditor);
        }

        Assertions.assertEquals(expected, out.toString());
    }

    @Test
    public void case3() {
        SimpleTextEditor simpleTextEditor = new SimpleTextEditor();
        String input =
                "50\n" + "1 zsfncpxdzl\n" + "3 4\n" + "3 6\n" + "2 1\n" + "3 7\n" + "3 2\n" + "4\n" + "2 4\n" + "2 6\n" + "4\n" + "4\n" + "1 l\n" + "1 hpe\n" + "3 6\n" + "2 7\n"
                        + "4\n" + "3 6\n" + "4\n" + "3 6\n" + "1 zipsqagri\n" + "1 vuqxstnj\n" + "4\n" + "3 13\n" + "4\n" + "3 10\n" + "3 6\n" + "1 uzdpy\n" + "1 bupqp\n"
                        + "1 kn\n" + "2 6\n" + "3 8\n" + "1 iiuvfbn\n" + "4\n" + "2 1\n" + "2 12\n" + "4\n" + "3 7\n" + "4\n" + "2 9\n" + "3 1\n" + "1 axbhx\n" + "1 wovbfyvt\n"
                        + "3 11\n" + "3 7\n" + "3 2\n" + "4\n" + "1 tjmqp\n" + "4\n" + "2 6\n" + "3 4";
        String expected = "n\n" + "p\n" + "x\n" + "s\n" + "p\n" + "p\n" + "p\n" + "i\n" + "l\n" + "p\n" + "d\n" + "x\n" + "z\n" + "b\n" + "x\n" + "s\n" + "n\n";
        StringBuilder out = new StringBuilder();
        Scanner scanner = new Scanner(new StringReader(input));
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            simpleTextEditor.performOperation(out, line);
            System.out.println(line + "===> " + simpleTextEditor);
        }

        Assertions.assertEquals(expected, out.toString());
    }
}
