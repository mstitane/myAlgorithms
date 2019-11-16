package com.stitane.solutions.hackerrank.visitorpattern;

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }

    @Override
    public String toString() {
        return "TreeLeaf{" + super.toString() +  '}';
    }
}
