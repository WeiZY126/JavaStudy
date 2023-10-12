package com.study.LeetCode.algorithm07Tree;

/**
 * 平衡二叉树
 */
public class Test06LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return isBalancing(root) != null;

    }

    public Integer isBalancing(TreeNode root) {
        if (root == null)
            return 0;
        Integer left = isBalancing(root.left);
        Integer right = isBalancing(root.right);
        if (left == null || right == null)
            return null;
        if (Math.abs(left - right) > 1)
            return null;
        return Math.max(left + 1, right + 1);
    }
}
