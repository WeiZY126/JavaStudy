package com.study.LeetCode.algorithm08Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度*
 */
public class Mar27LeetCode104 {
    /*递归*/
    public int LeetCode104Recursion(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(LeetCode104Recursion(root.left), LeetCode104Recursion(root.right)) + 1;
    }

    /*迭代*/
    public int LeetCode104Circulate(TreeNode root) {
        if (root == null)
            return 0;
        //借助队列
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            //记录本层节点个数
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }

}
