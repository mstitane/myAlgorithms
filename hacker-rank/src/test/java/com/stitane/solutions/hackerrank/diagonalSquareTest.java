package com.stitane.solutions.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import static com.stitane.solutions.hackerrank.DiagonalSquare.divided;
import static org.junit.Assert.assertArrayEquals;

public class diagonalSquareTest {

    @Test
    public void dividedOf5() {
        Long[][] arr = { { 1L, 1L, 1L, 1L, 1L }, { 2L, 2L, 2L, 2L, 2L }, { 3L, 3L, 3L, 3L, 3L }, { 4L, 4L, 4L, 4L, 4L }, { 5L, 5L, 5L, 5L, 5L } };
        List<List<Long>> collect = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
        List<Long> longs = divided(collect);
        List<Long> expected = Arrays.asList(5L, 12L, 12L, 19L);
        assertArrayEquals(expected.toArray(), longs.toArray());
    }

    @Test
    public void dividedOf7() {
        Long[][] arr = { { 2L, 5L, 7L, 3L, 9L, 2L, 6L }, { 5L, 10L, 3L, 8L, 7L, 8L, 5L }, { 6L, 4L, 9L, 11L, 0L, 3L, 7L }, { 4L, 2L, 13L, 6L, 2L, 9L, 4L },
                { 8L, 0L, 9L, 14L, 10L, 8L, 3L }, { 5L, 10L, 12L, 2L, 6L, 4L, 2L }, { 4L, 9L, 3L, 8L, 7L, 4L, 5L } };

        List<List<Long>> collect = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
        List<Long> longs = divided(collect);
        List<Long> expected = Arrays.asList(55L, 47L, 43L, 65L);
        assertArrayEquals(expected.toArray(), longs.toArray());
    }
}