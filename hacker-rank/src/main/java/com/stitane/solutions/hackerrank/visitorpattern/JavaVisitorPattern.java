package com.stitane.solutions.hackerrank.visitorpattern;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaVisitorPattern {

    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, Set<Integer>> map;

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        InputStream in = JavaVisitorPattern.class.getResourceAsStream("/testCase1.txt");
        Scanner scan = new Scanner(in);
        int n = scan.nextInt();

        values = new int[n];
        colors = new Color[n];
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            values[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            colors[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            Set<Integer> parentEdges = map.get(u);
            if (parentEdges == null) {
                parentEdges = new HashSet<>();
                map.put(u, parentEdges);
            }
            parentEdges.add(v);

            Set<Integer> childEdges = map.get(v);
            if (childEdges == null) {
                childEdges = new HashSet<>();
                map.put(v, childEdges);
            }
            childEdges.add(u);
        }
        scan.close();

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static void addChildren(TreeNode parent, Integer parentNum) {
        for (Integer childNum : map.get(parentNum)) {
            map.get(childNum).remove(parentNum);

            Set<Integer> grandChildren = map.get(childNum);
            Tree tree;
            if (grandChildren != null && !grandChildren.isEmpty()) {
                tree = new TreeNode(values[childNum - 1], colors[childNum - 1], parent.getDepth() + 1);
                addChildren((TreeNode) tree, childNum);
            } else {
                tree = new TreeLeaf(values[childNum - 1], colors[childNum - 1], parent.getDepth() + 1);
            }
            parent.addChild(tree);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}