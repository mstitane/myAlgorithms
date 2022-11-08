package com.stitane.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSolution {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int size = vals.size();
        ListNode dummy = new ListNode(0);
        head = dummy;
        for (int i = 0; i < size; i++) {
            int val = vals.get(i);
            if (i != size - n) {
                dummy.next = new ListNode(val);
                dummy = dummy.next;
            }
        }
        return head.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = rev;
            rev = node;
            head = head.next;
        }
        return rev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (list1 != null && list2 != null) {

            ListNode node;
            if (list1.val < list2.val) {
                node = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }
            if (current == null)
                current = node;
            else
                current.next = node;
            current = current.next;
        }
        if (list1 != null)
            current.next = list1;

        if (list2 != null)
            current.next = list2;
        return head.next;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int size = vals.size();
        for (int i = 0; i < size; i++) {
            int a = vals.get(i);
            int b = vals.get(size - 1 - i);
            if (a != b)
                return false;

        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null && next != null && next.next != null) {
            if (next == current)
                return true;
            next = next.next.next;
            current = current.next;
        }
        return false;
    }
}
