package com.stitane.solutions.hackerrank.visitorpattern;

import java.util.ArrayList;

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "TreeNode{" + super.toString() + "children=" + children + '}';
    }
}
