package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的最小深度
 */
public class Test07LeetCode111 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(new Test07LeetCode111().minDepth(treeNode));

    }

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = root;
        int res = 1;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left == null && node.right == null)
                    return res;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res++;
        }
        return res;
    }
}
