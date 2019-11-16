package com.stitane.solutions.hackerrank.visitorpattern;

interface TreeVis {
    int getResult();

    void visitNode(TreeNode node);

    void visitLeaf(TreeLeaf leaf);

}
