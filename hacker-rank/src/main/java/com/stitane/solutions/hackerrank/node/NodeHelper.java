package com.stitane.solutions.hackerrank.node;

import java.io.StringWriter;

public class NodeHelper {

    private NodeHelper() {
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void print(StringWriter out, String prefix, Node n, boolean isLeft) {
        if (n != null) {
            out.append(prefix).append(isLeft ? "|-- " : "\\-- ").append(String.valueOf(n.data)).append("\n");
            print(out, prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(out, prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public static void postOrder(StringWriter out, Node root) {
        if (root == null)
            return;

        postOrder(out, root.left);

        postOrder(out, root.right);

        out.append(String.valueOf(root.data)).append(" ");
    }
}
