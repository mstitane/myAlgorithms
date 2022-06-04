package com.stitane.solutions.hackerrank.java_braces;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parser {

    private Parser(){}
    public static String isBalanced(String s) {
        final String NO = "NO";
        final String YES = "YES";
        Deque<Character> stack = new ArrayDeque<>();
        char x;
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return NO;
            }
            x = stack.getFirst();

            if (c == ')') {
                stack.pop();
                if (x == '{' || x == '[')
                    return NO;
            } else if (c == '}') {
                stack.pop();
                if (x == '(' || x == '[')
                    return NO;
            } else if (c == ']') {
                stack.pop();
                if (x == '(' || x == '{')
                    return NO;
            }
        }
        return stack.isEmpty() ? YES : NO;
    }
}
