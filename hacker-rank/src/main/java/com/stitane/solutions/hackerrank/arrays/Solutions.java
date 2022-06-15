package com.stitane.solutions.hackerrank.arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solutions {

    private Solutions() {
    }

    public static String plusMinus(int[] arr) {
        int countPositives = 0;
        int countNegatives = 0;
        int countZero = 0;
        for (int i : arr) {
            if (i > 0) {
                countPositives++;
            } else if (i < 0) {
                countNegatives++;
            } else
                countZero++;
        }
        StringBuilder out = new StringBuilder();
        out.append(BigDecimal.valueOf((double) countPositives / arr.length).setScale(6, RoundingMode.CEILING)).append("\n");
        out.append(BigDecimal.valueOf((double) countNegatives / arr.length).setScale(6, RoundingMode.CEILING)).append("\n");
        out.append(BigDecimal.valueOf((double) countZero / arr.length).setScale(6, RoundingMode.CEILING)).append("\n");
        return out.toString();
    }

    public static String staircase(int n) {
        int m = n - 1;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = String.join("", Collections.nCopies(m, " "));
            String p = String.join("", Collections.nCopies(n - m, "#"));
            out.append(s).append(p).append("\n");
            m--;
        }
        return out.toString();
    }

    public static int minMaxSum(int k, List<Integer> arr) {
        k -= 1;
        Collections.sort(arr);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i = 0; i < arr.size() - k; i++) {
            min.add(arr.get(i + k) - arr.get(i));
        }
        return min.peek();
    }

    public static String currencyCode(double amount) {
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        String india = currencyInstance.format(amount).replace("$", "Rs.");
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);
        StringBuilder out = new StringBuilder();
        out.append("US: ").append(us).append("\n");
        out.append("India: ").append(india).append("\n");
        out.append("China: ").append(china).append("\n");
        out.append("France: ").append(france).append("\n");
        return out.toString();
    }

    static Integer hourglassSum(int[][] arr) {
        Set<Integer> sum = new HashSet<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
            }
        }

        return sum.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public static int[] rotLeft(int[] a, int d) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        Collections.rotate(list, a.length - d);

        return list.stream().mapToInt(i -> i).toArray();
    }

    static void update(long[] arrayD, int l, int r, long x) {
        arrayD[l] += x;
        arrayD[r + 1] -= x;
    }

    public static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long[] arrayD = new long[n + 1];
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            long k = query[2];
            update(arrayD, a, b, k);
        }
        return getMaxValue(array, arrayD);
    }

    private static long getMaxValue(long[] array, long[] arrayD) {
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = arrayD[i];
            } else {
                array[i] = arrayD[i] + array[i - 1];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        SortedMap<String, Integer> counter = new TreeMap<>();
        int i = 0;
        for (String query : queries) {
            i++;
            for (String string : strings) {
                if (string.equals(query))
                    counter.merge(String.format("%09d", i) + query, 1, Integer::sum);
                else
                    counter.merge(String.format("%09d", i) + query, 0, Integer::sum);
            }

        }

        return new ArrayList<>(counter.values());
    }

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

    public static List<Integer> contacts(List<List<String>> queries) {
        Map<String, Integer> counter = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (List<String> query : queries) {
            String action = query.get(0);
            String word = query.get(1);
            if ("add".equals(action)) {
                StringBuilder key = new StringBuilder();
                for (Character s : word.toCharArray()) {
                    key.append(s);
                    counter.merge(key.toString(), 1, Integer::sum);
                }
            } else if ("find".equals(action)) {
                result.add(counter.getOrDefault(word, 0));
            }
        }
        return result;
    }

    public static List<Double> runningMedian(List<Integer> integers) {
        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer v : integers) {
            if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
                maxHeap.offer(v);
            } else {
                minHeap.offer(v);
            }

            if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > (maxHeap.size() + 1)) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size()) {
                BigDecimal value = BigDecimal.valueOf(maxHeap.peek());
                result.add(value.setScale(1, RoundingMode.HALF_UP).doubleValue());
            } else if (minHeap.size() > maxHeap.size()) {
                BigDecimal value = BigDecimal.valueOf(minHeap.peek());
                result.add(value.setScale(1, RoundingMode.HALF_UP).doubleValue());
            } else if (!minHeap.isEmpty()) {
                BigDecimal value = BigDecimal.valueOf(0.5 * (minHeap.peek() + maxHeap.peek()));
                result.add(value.setScale(1, RoundingMode.HALF_UP).doubleValue());
            }
        }

        return result;
    }

    public static List<Integer> getMax(List<String> operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> result = new ArrayList<>();
        for (String operation : operations) {
            String[] items = operation.split(" ");
            if ("1".equals(items[0])) {
                int val = Integer.parseInt(items[1]);
                stack.push(val);
                max.add(val);
            } else if ("2".equals(items[0])) {
                Integer val = stack.pop();
                max.remove(val);
            } else
                result.add(max.peek());
        }

        return result;
    }
}