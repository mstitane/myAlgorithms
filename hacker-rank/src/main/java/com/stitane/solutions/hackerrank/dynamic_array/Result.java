package com.stitane.solutions.hackerrank.dynamic_array;

import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        List<Integer> aList = new ArrayList<>();
        int lastAnswer = 0;
        for (List<Integer> q : queries) {
            Integer x = q.get(1);
            Integer y = q.get(2);
            int idx = (x ^ lastAnswer) % n;
            if (q.get(0) == 1) {
                arr.get(idx).add(y);
            } else if (q.get(0) == 2) {
                int j = y % arr.get(idx).size();
                lastAnswer = arr.get(idx).get(j);
                aList.add(lastAnswer);
            }
        }
        return aList;
    }

}
