package com.stitane;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private final Deque<Integer> array;
    private final Deque<Integer> mins;

    public MinStack() {
        array = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }

    public void push(int val) {
        array.push(val);
        if (!mins.isEmpty())
            mins.push(Math.min(mins.peek(), val));
        else
            mins.push(val);
    }

    public void pop() {
        if (!mins.isEmpty())
            mins.pop();
        if (!array.isEmpty())
            array.pop();
    }

    public int top() {
        if (!array.isEmpty())
            return array.peek();
        else
            return 0;
    }

    public int getMin() {
        return !mins.isEmpty() ? mins.peek() : -1;
    }
}