package com.stitane.solutions.hackerrank.node;

public class DoublyLinkedListHelper {
    private DoublyLinkedListHelper() {
    }

    public static String printList(DoublyLinkedListNode node, String sep) {
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

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode root = null;
        while (llist != null) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(llist.data);
            if (root != null)
                root.prev = node;
            node.next = root;
            root = node;
            llist = llist.next;
        }
        return root;
    }
}