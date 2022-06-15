package com.stitane.solutions.hackerrank.nodes;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import com.stitane.solutions.hackerrank.node.Node;
import com.stitane.solutions.hackerrank.node.NodeHelper;
import org.junit.Assert;
import org.junit.Test;

public class NodeSolutionTests {

    @Test
    public void postorder_traversal_case1() {
        String input = "6\n" + "1 2 5 3 6 4\n";
        String expected = "4 3 6 5 2 1 ";
        Scanner scan = new Scanner(new StringReader(input));
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = NodeHelper.insert(root, data);
        }
        scan.close();

        StringWriter out = new StringWriter();
        NodeHelper.postOrder(out, root);
        Assert.assertEquals(expected, out.toString());
    }

    @Test
    public void postorder_traversal_case2() {
        String input = "15\n" + "1 14 3 7 4 5 15 6 13 10 11 2 12 8 9\n";
        String expected = "2 6 5 4 9 8 12 11 10 13 7 3 15 14 1 ";
        Scanner scan = new Scanner(new StringReader(input));
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = NodeHelper.insert(root, data);
        }
        scan.close();

        StringWriter out = new StringWriter();
        NodeHelper.postOrder(out, root);
        Assert.assertEquals(expected, out.toString());
    }

}
