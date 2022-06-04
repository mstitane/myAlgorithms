package com.stitane.solutions.hackerrank.node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class SinglyLinkedListSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

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

        SinglyLinkedListNode llist1 = SinglyLinkedListHelper.deleteNode(llist.head, position);

        SinglyLinkedListHelper.printList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
