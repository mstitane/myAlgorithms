package com.stitane.solutions.hackerrank.nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.IntStream;

import com.stitane.solutions.hackerrank.node.DoublyLinkedList;
import com.stitane.solutions.hackerrank.node.DoublyLinkedListHelper;
import com.stitane.solutions.hackerrank.node.DoublyLinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListSolutionTests {

    @Test
    public void print_the_elements_of_alinked_list() throws IOException {
        String input = "2\n" + "16\n" + "13\n";
        String expected = "16\n" + "13\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        DoublyLinkedList llist = new DoublyLinkedList();
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
        String result = DoublyLinkedListHelper.printList(llist.head, "\n") + "\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void reverse_a_doubly_linked_list() throws IOException {
        String input = "1\n" + "4\n" + "1\n" + "2\n" + "3\n" + "4\n";
        String expected = "4\n3\n2\n1";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();
                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());
                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                DoublyLinkedListNode llist1 = DoublyLinkedListHelper.reverse(llist.head);

                String result = DoublyLinkedListHelper.printList(llist1, "\n");
                Assert.assertEquals(expected, result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
