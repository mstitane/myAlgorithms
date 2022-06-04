package com.stitane.solutions.hackerrank.visitorpattern;

public class ProductOfRedNodesVisitor implements TreeVis {
    private final int modulo = (int) Math.pow(10, 9) + 7;
    private long redLeaves = 1;

    public int getResult() {
        return (int) redLeaves;
    }

    public void visitNode(TreeNode node) {
        if (Color.RED.equals(node.getColor())) {
            redLeaves = (redLeaves * node.getValue()) % modulo;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.RED.equals(leaf.getColor())) {
            redLeaves = (redLeaves * leaf.getValue()) % modulo;
        }
    }
}
