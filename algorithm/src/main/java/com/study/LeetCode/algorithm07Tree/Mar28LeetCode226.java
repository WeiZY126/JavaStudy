package com.study.LeetCode.algorithm07Tree;

/**
 * 反转二叉树*
 */
public class Mar28LeetCode226 {
    public TreeNode LeetCode226Recursion(TreeNode root) {
        if (root == null)
            return root;
        LeetCode226Recursion(root.left);
        LeetCode226Recursion(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
