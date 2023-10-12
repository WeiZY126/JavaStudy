package com.study.LeetCode.algorithm08Tree;

/**
 * 二叉树的最近公共祖先
 */
public class Test09LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        if (left != null && right != null)
            return root;
        //right找到了,或者最近的节点在right
        if (right != null) {
            return right;
        }
        //left找到了，或者最近的节点在left
        if (left != null) {
            return left;
        }
        //都没找到，返回null
        return null;
    }
}
