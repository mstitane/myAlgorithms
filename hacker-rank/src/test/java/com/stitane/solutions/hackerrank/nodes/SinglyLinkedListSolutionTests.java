package com.stitane.solutions.hackerrank.nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.stitane.solutions.hackerrank.node.SinglyLinkedList;
import com.stitane.solutions.hackerrank.node.SinglyLinkedListHelper;
import com.stitane.solutions.hackerrank.node.SinglyLinkedListNode;
import org.junit.Assert;
import org.junit.Test;

import static com.stitane.solutions.hackerrank.node.SinglyLinkedListHelper.insertNodeAtPosition;

public class SinglyLinkedListSolutionTests {

    @Test
    public void print_the_elements_of_alinked_list() throws IOException {
        String input = "2\n" + "16\n" + "13\n";
        String expected = "16\n" + "13\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new UnsupportedOperationException(ex);
            }
        });
        bufferedReader.close();
        String result = SinglyLinkedListHelper.printList(llist.head, "\n") + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void insert_a_node_at_the_tail_of_a_linked_list() throws IOException {
        String input = "5\n141\n302\n164\n530\n474\n";
        String expected = "141\n302\n164\n530\n474\n";
        Scanner scanner = new Scanner(new StringReader(input));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            llist.head = SinglyLinkedListHelper.insertNodeAtTail(llist.head, llistItem);
        }
        String result = SinglyLinkedListHelper.printList(llist.head, "\n") + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void insert_a_node_at_the_head_of_a_linked_list() throws IOException {
        String input = "5\n" + "383\n" + "484\n" + "392\n" + "975\n" + "321\n";
        String expected = "321\n" + "975\n" + "392\n" + "484\n" + "383\n";
        Scanner scanner = new Scanner(new StringReader(input));
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            llist.head = SinglyLinkedListHelper.insertNodeAtHead(llist.head, llistItem);
        }
        String result = SinglyLinkedListHelper.printList(llist.head, "\n") + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void insert_a_node_at_a_specific_position_in_a_linked_list() throws IOException {
        String input = "3\n" + "16\n" + "13\n" + "7\n" + "1\n" + "2\n";
        String expected = "16\n13\n1\n7\n";
        Scanner scanner = new Scanner(new StringReader(input));

        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
        String result = SinglyLinkedListHelper.printList(llist_head, "\n") + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void delete_a_node() throws IOException {
        String input = "8\n" + "20\n" + "6\n" + "2\n" + "19\n" + "7\n" + "4\n" + "15\n" + "9\n" + "3\n";
        String expected = "20\n6\n2\n7\n4\n15\n9";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new UnsupportedOperationException(ex);
            }
        });
        int position = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();
        SinglyLinkedListNode llist1 = SinglyLinkedListHelper.deleteNode(llist.head, position);
        String result = SinglyLinkedListHelper.printList(llist1, "\n");
        Assert.assertEquals(expected, result);
    }
}
