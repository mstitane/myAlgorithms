package com.stitane.strings;

public class StringsSolution {
    public void reverseString(char[] s) {
        char[] chars = String.copyValueOf(s).toCharArray();
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            s[j++] = chars[i];
        }
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE ? (int) result : 0;
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int charsLength = chars.length;
        for (int i = 0; i < charsLength; i++) {
            char c = chars[i];
            int count = 0;
            for (int j = 0; j < charsLength; j++) {
                if (c == chars[j]) {
                    count++;
                    if (count > 1)
                        break;
                }
            }
            if (count == 1)
                return i;
        }

        return -1;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0, charArrayLength = chars.length; i < charArrayLength; i++) {
            counts[chars[i] - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        int j = length - 1;
        while (i < length && j > 0) {
            char a = chars[i];
            char b = chars[j];
            if (!(Character.isDigit(a) || Character.isAlphabetic(a))) {
                i++;
            } else if (!(Character.isDigit(b) || Character.isAlphabetic(b)))
                j--;
            else if (Character.toLowerCase(a) != Character.toLowerCase(b))
                return false;
            else {
                j--;
                i++;
            }
        }
        return true;
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1;
        int i = 0;
        int length = str.length();
        char char0 = str.charAt(0);
        if (char0 == '-' || char0 == '+') {
            sign = char0 == '-' ? -1 : 1;
            i++;
        }
        int n = 0;
        while (i < length) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int d = Character.getNumericValue(ch);
                if (n > (Integer.MAX_VALUE - d) / 10) {
                    n = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return n;
                }
                n = n * 10 + d;
            } else {
                break;
            }
            i++;
        }
        return sign * n;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int length = strs.length;
        for (char str : strs[0].toCharArray()) {
            StringBuilder s = new StringBuilder(prefix);
            s.append(str);
            for (int i = 1; i < length; i++) {
                if (!strs[i].startsWith(s.toString()))
                    return prefix.toString();
            }
            prefix = new StringBuilder(s);
        }
        return prefix.toString();
    }
}