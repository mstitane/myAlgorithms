package com.stitane.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysSolution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int maxProfit = 0;

        for (int i = 1, pricesLength = prices.length; i < pricesLength; i++) {
            if (prices[i] < min && max == 0) {
                min = prices[i];
            } else if (prices[i] > max)
                max = prices[i];
            else {
                maxProfit += max - min;
                min = prices[i];
                max = 0;
            }
        }
        if (max > 0)
            maxProfit += max - min;
        return maxProfit;
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int l = nums.length - 1;
        reverse(nums, 0, l);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l);
    }

    private void reverse(int[] nums, int i, int j) {
        int tmp;
        while (j > i) {
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            j--;
            i++;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for (Integer n : nums) {
            if (dups.contains(n))
                return true;
            dups.add(n);
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> counters = new HashMap<>();
        for (int n : nums)
            counters.merge(n, 1, Integer::sum);
        return counters.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(0);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] arr = new int[a + b];
        while (i < a && j < b) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                arr[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] plusOne(int[] digits) {
        String s = Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining(""));
        java.math.BigInteger big = new java.math.BigInteger(s).add(java.math.BigInteger.ONE);
        return big.toString().chars().map(Character::getNumericValue).toArray();
    }

    public void moveZeroes(int[] nums) {
        int l = nums.length;

        int index = 0;
        for (int num : nums) {
            if (num != 0)
                nums[index++] = num;
        }

        for (int i = index; i < l; i++) {
            nums[i] = 0;
        }

    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public boolean isValidSudoku(char[][] board) {

        // valid subLists
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                Set<Integer> set = new HashSet<>();
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        if (board[r][c] == '.')
                            continue;
                        int val = Character.getNumericValue(board[r][c]);
                        if (!set.add(val)) {
                            return false;
                        }
                    }
                }
            }
        }
        // valid rows
        for (int c = 0; c < 9; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.')
                    continue;
                int val = Character.getNumericValue(board[r][c]);
                if (!set.add(val)) {
                    return false;
                }
            }
        }
        // valid cols
        for (int c = 0; c < 9; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[c][r] == '.')
                    continue;
                int val = Character.getNumericValue(board[r][c]);
                if (!set.add(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotate(int[][] matrices) {
        int n = matrices.length;
        int depth = n / 2;
        for (int i = 0; i < depth; i++) {
            int len = n - 2 * i - 1;
            int pos = n - 1 - i;
            for (int j = 0; j < len; j++) {
                int temp = matrices[i][i + j];
                matrices[i][i + j] = matrices[pos - j][i];
                matrices[pos - j][i] = matrices[pos][pos - j];
                matrices[pos][pos - j] = matrices[i + j][pos];
                matrices[i + j][pos] = temp;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int k = m + n - 1;
        while (b >= 0) {
            if (a >= 0 && nums1[a] > nums2[b])
                nums1[k--] = nums1[a--];
            else
                nums1[k--] = nums2[b--];
        }
    }

    //Check If N and Its Double Exist
    public boolean checkIfExist(int[] arr) {
        Set<Integer> doubles = new HashSet<>();
        for (int i : arr) {
            if (doubles.contains(i * 2))
                return true;
            else if (i % 2 == 0 && doubles.contains(i / 2))
                return true;
            else
                doubles.add(i);
        }
        return false;
    }

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int i = 0;

        if (len < 3)
            return false;
        // walk up
        while (i + 1 < len && arr[i] < arr[i + 1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == len - 1)
            return false;

        // walk down
        while (i + 1 < len && arr[i] > arr[i + 1])
            i++;

        return i == len - 1;
    }

    public int[] replaceElements(int[] arr) {
        int len = arr.length;

        if (len <= 1)
            return new int[] { -1 };
        for (int j = 0; j < len; j++) {
            arr[j] = max(arr, j + 1, len);
        }
        return arr;
    }

    private int max(int[] arr, int i, int len) {
        if (i == len)
            return -1;
        int max = 0;
        for (int j = i; j < len; j++) {
            if (arr[j] > max)
                max = arr[j];
        }
        return max;
    }

    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int i = 0;
        int j = len - 1;

        for (int num : nums) {
            if (num % 2 == 0)
                ans[i++] = num;
            else
                ans[j--] = num;
        }
        return ans;
    }

    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();

        int length = heights.length;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != heights[i])
                count++;
        }
        return count;
    }

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> taken = new HashSet<>();

        for (int num : nums) {
            if (taken.contains(num)) {
                continue;
            }
            if (minHeap.size() == 3) {
                if (minHeap.peek() < num) {
                    taken.remove(minHeap.poll());
                    minHeap.add(num);
                    taken.add(num);
                }
            } else {
                minHeap.add(num);
                taken.add(num);
            }
        }

        if (minHeap.size() == 1) {
            return minHeap.peek();
        } else if (minHeap.size() == 2) {
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        } else
            return minHeap.peek();
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            int j = Math.abs(n);
            if (nums[j - 1] > 0)
                nums[j - 1] *= -1;
        }
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}