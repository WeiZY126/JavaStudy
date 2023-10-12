package com.study.LeetCode.algorithm07Tree;

/**
 * 平衡二叉树*
 */
public class Mar27LeetCode110 {
    public boolean LeetCode110(TreeNode root) {
        if (root == null)
            return true;
        if (Recursion(root) == -1)
            return false;
        return true;
    }

    public static int Recursion(TreeNode root) {
        if (root == null)
            return 0;
        int left = Recursion(root.left);
        int right = Recursion(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
