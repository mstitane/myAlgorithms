package com.stitane.solutions.hackerrank.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QueueSolution {
    private QueueSolution() {
    }

    /**
     * https://www.hackerrank.com/challenges/qheap1/problem?isFullScreen=true
     *
     * @param source an input string
     * @return an output
     */
    public static String basicQueueOperation(String source) {
        Scanner sc = new Scanner(source);
        StringBuilder out = new StringBuilder();
        int q = sc.nextInt();
        sc.nextLine();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int val = sc.nextInt();
                queue.add(val);
            } else if (type == 2) {
                int val = sc.nextInt();
                queue.remove(val);
            } else {
                out.append(queue.peek()).append("\n");
            }
        }
        sc.close();
        return out.toString();
    }

    /**
     * https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem
     * @param source an input string
     * @return an output
     */
    public static String queueUsingTwoStacks(String source) {
        Scanner sc = new Scanner(source);
        int q = sc.nextInt();
        sc.nextLine();
        Deque<Integer> queue = new LinkedList<>();

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1)
                queue.addLast(sc.nextInt());
            else if (type == 2)
                queue.removeFirst();
            else if (type == 3)
                out.append(queue.getFirst()).append("\n");
            sc.nextLine();

        }
        sc.close();
        return out.toString();
    }

    public static int cookies(int k, List<Integer> integers) {
        Queue<Integer> queue = new PriorityQueue<>();
        int ix = 0;

        integers.stream().sorted().forEach(queue::add);

        while (!queue.isEmpty() && queue.peek() < k) {
            Integer a = Optional.ofNullable(queue.poll()).orElse(null);
            Integer b = Optional.ofNullable(queue.poll()).orElse(null);
            if (a != null && b != null) {
                queue.add(a + (b * 2));
                ix++;
            }
        }

        if (queue.isEmpty())
            return -1;
        else
            return ix;
    }
}
