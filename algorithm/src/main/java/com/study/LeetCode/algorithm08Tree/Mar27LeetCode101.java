package com.study.LeetCode.algorithm08Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树*
 */
public class Mar27LeetCode101 {

    /*递归*/
    public boolean LeetCode101(TreeNode root) {
        if (root == null)
            return false;
        return LeetCode101Recursion(root.left, root.right);
    }

    public boolean LeetCode101Recursion(TreeNode left, TreeNode right) {
        if (left.left == null && right.right == null)
            return true;
        if (left.left == null || right.right == null)
            return false;
        if (left.val != right.val)
            return false;
        //递归比较左子树的左孩子-右子树的右孩子和右子树的左孩子-左子树的右孩子
        return LeetCode101Recursion(left.left, right.right) && LeetCode101Recursion(left.right, right.left);
    }

    /*迭代*/
    public static boolean LeetCode101Circulate(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root.left == null && root.right == null)
            return true;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);

        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        System.out.println(LeetCode101Circulate(treeNode));
    }
}
