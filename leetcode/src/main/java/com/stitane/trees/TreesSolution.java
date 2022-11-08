package com.stitane.trees;

import java.util.ArrayList;
import java.util.List;

public class TreesSolution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        List<Integer> parent = new ArrayList<>();
        parent.add(root.val);
        list.add(parent);
        levelOrderChilds(list, root, 1);

        return list;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r){
        if (l>r) return null;
        if (l==r) return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid-1);
        root.right = helper(nums, mid+1, r);
        return root;
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null)
            return leftNode == rightNode;

        if (leftNode.val != rightNode.val)
            return false;

        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    private void levelOrderChilds(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null)
            return;
        List<Integer> childs = new ArrayList<>();
        if (root.left != null)
            childs.add(root.left.val);
        if (root.right != null)
            childs.add(root.right.val);
        if (!childs.isEmpty()) {
            if (list.size() > level)
                list.get(level).addAll(childs);
            else
                list.add(childs);
        }
        level++;
        levelOrderChilds(list, root.left, level);
        levelOrderChilds(list, root.right, level);
    }
}