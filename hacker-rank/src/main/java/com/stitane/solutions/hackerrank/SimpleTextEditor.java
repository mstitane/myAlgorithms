package com.stitane.solutions.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem?isFullScreen=true
 */
public class SimpleTextEditor {
    Deque<String> stack = new ArrayDeque<>();

    public void append(String string) {
        String newString = (stack.isEmpty() ? "" : stack.peek()).concat(string);
        stack.push(newString);
    }

    public void remove(int index) {
        String finalString = (stack.isEmpty() ? "" : stack.peek());
        finalString = finalString.substring(0, finalString.length() - index);
        stack.push(finalString);
    }

    public Character print(int key) {
        if (!stack.isEmpty()) {
            return stack.peek().charAt(key - 1);
        }
        return null;
    }

    public void undo() {
        stack.pop();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleTextEditor.class.getSimpleName() + "[", "]").add("stack=" + stack).toString();
    }

    public void performOperation(StringBuilder out, String line) {
        String[] strings = line.split("\\s+");
        if ("1".equals(strings[0])) {
            append(strings[1]);
        } else if ("2".equals(strings[0])) {
            remove(Integer.parseInt(strings[1]));
        } else if ("3".equals(strings[0])) {
            out.append(print(Integer.parseInt(strings[1]))).append("\n");
        } else if ("4".equals(strings[0])) {
            undo();
        } else {
            throw new IllegalStateException("Unexpected value: " + strings[0]);
        }
    }
}
