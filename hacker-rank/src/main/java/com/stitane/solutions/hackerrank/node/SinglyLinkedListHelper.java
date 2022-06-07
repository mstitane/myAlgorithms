package com.stitane.solutions.hackerrank.node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedListHelper {
    private SinglyLinkedListHelper() {
    }

    public static String printList(SinglyLinkedListNode node, String sep) {
        StringBuilder out = new StringBuilder();
        while (node != null) {
            out.append(node.data);
            node = node.next;
            if (node != null) {
                out.append(sep);
            }
        }
        return out.toString();
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode root = head;
        int i = 0;
        while (head != null) {
            if (position == ++i) {
                node.next = head.next;
                head.next = node;
            }
            head = head.next;
        }
        return root;

    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode h1, SinglyLinkedListNode h2) {

        SinglyLinkedList head = new SinglyLinkedList();
        List<Integer> vals = new ArrayList<>();
        while (h1 != null) {
            vals.add(h1.data);
            h1 = h1.next;
        }

        while (h2 != null) {
            vals.add(h2.data);
            h2 = h2.next;
        }
        vals.stream().sorted(Comparator.naturalOrder()).forEach(head::insertNode);
        return head.head;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        int count = 0;
        SinglyLinkedListNode temp = head, prev = null;
        if (position == 0)
            return head.next;
        while (temp != null) {
            if (count == position)
                break;
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = temp.next;
        return head;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        Deque<Integer> q = new LinkedList<>();
        while (llist != null) {
            q.addFirst(llist.data);
            llist = llist.next;
        }
        SinglyLinkedList linkedList = new SinglyLinkedList();
        while (!q.isEmpty()) {
            linkedList.insertNode(q.poll());
        }
        return linkedList.head;
    }

    public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode root = head;
        if (head == null)
            return new SinglyLinkedListNode(data);
        while (head.next != null) {
            head = head.next;
        }
        head.next = new SinglyLinkedListNode(data);
        return root;
    }

    public static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;
        return node;
    }
}