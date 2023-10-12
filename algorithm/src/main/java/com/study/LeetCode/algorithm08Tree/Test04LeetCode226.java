package com.study.LeetCode.algorithm08Tree;

/**
 * 翻转二叉树
 */
public class Test04LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null)
            return root;
        left = invertTree(left);
        right = invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }
}
