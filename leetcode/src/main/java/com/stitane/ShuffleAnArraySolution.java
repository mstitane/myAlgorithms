package com.stitane;

import java.util.Random;

public class ShuffleAnArraySolution {
    private int[] array;
    private final int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleAnArraySolution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}