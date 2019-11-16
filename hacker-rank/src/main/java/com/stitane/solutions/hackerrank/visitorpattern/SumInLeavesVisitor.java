package com.stitane.solutions.hackerrank.visitorpattern;

class SumInLeavesVisitor implements TreeVis {
    private int sum;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}
