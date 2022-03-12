package com.stitane.solutions.hackerrank.java_braces;

import java.util.ArrayDeque;
import java.util.Deque;

class Parser {
    static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char x;

        // Traversing the Expression
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return String.valueOf(false);
            }
            x = stack.getFirst();

            switch (c) {
            case ')':
                stack.pop();
                if (x == '{')
                    return String.valueOf(false);
                break;

            case '}':
                stack.pop();
                if (x == '(')
                    return String.valueOf(false);
                break;
            }
        }
        return String.valueOf(stack.isEmpty());
    }
}
