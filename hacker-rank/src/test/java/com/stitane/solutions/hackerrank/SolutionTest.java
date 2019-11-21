package com.stitane.solutions.hackerrank;

import com.stitane.solutions.hackerrank.arrays.Solution;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void plusMinus() {
        Solution.plusMinus(new int[] { 1, 2 });
        Assert.assertTrue(true);
    }

    @Test
    public void staircase() {
        Solution.staircase(6);
        Assert.assertTrue(true);
    }
}