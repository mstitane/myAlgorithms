package com.stitane.solutions.hackerrank.visitorpattern;

public class FancyVisitor implements TreeVis {
    private int evenNodeDepthSum;
    private int sumOfGreenLeaves;

    public int getResult() {
        return Math.abs(evenNodeDepthSum - sumOfGreenLeaves);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenNodeDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.GREEN.equals(leaf.getColor())) {
            sumOfGreenLeaves += leaf.getValue();
        }
    }
}
