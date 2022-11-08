package com.stitane.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathSolutions {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] primes = new boolean[n];

        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) {
                for (int j = i; j * i < primes.length; j++)
                    primes[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i])
                count++;
        }

        return count;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                result.add("FizzBuzz");

            else if (i % 3 == 0)
                result.add("Fizz");

            else if (i % 5 == 0)
                result.add("Buzz");
            else
                result.add(i + "");
        }
        return result;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        char[] chars = s.toCharArray();
        int n = 0;
        for (int i = 0, charArrayLength = chars.length; i < charArrayLength; i++) {
            Character c1 = chars[i];
            int v1 = values.getOrDefault(c1, -1);
            if (i + 1 < charArrayLength) {
                Character c2 = chars[i + 1];
                int v2 = values.getOrDefault(c2, -1);
                if (v1 >= v2)
                    n += v1;
                else {
                    n += v2 - v1;
                    ++i;
                }
            } else {
                n += v1;
            }
        }
        return n;
    }

    public int hammingWeight(int n) {
        String x = Integer.toBinaryString(n);
        x = x.replace("0", "");
        return x.length();
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int reverseBits(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }

    public int missingNumber(int[] nums) {
        int miss = 0;
        int i = 0;
        int length = nums.length;
        for (i = 0; i < length; i++) {
            miss = miss ^ i ^ nums[i];
        }

        return miss ^ i;
    }
}
