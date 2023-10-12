package com.study.LeetCode.algorithm07Tree;

/**
 * 二叉树的最大深度
 */
public class Test08LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
