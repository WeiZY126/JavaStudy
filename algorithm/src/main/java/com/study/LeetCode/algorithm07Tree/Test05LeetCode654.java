package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大二叉树
 */
public class Test05LeetCode654 {
    //单调栈O(n) O(n)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode treeNode = new TreeNode(num);
            if (deque.isEmpty()) {
                deque.push(treeNode);
                continue;
            }

            //如果当前值小于栈顶值
            //栈顶.right=当前值
            //当前值入栈
            if (num < deque.peek().val) {
                deque.peek().right = treeNode;
                deque.push(treeNode);
            } else {
                //如果当前值大于栈顶值
                //当前值.left = 栈顶出栈值
                while (!deque.isEmpty() && num > deque.peek().val) {
                    treeNode.left = deque.pop();
                }

                //当前值入栈，并执行[栈顶.right=当前值]动作
                if(!deque.isEmpty()){
                    deque.peek().right = treeNode;
                }
                deque.push(treeNode);
            }
        }
        return deque.peekLast();
    }

    //递归 O(n^2) O(n^2)
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        TreeNode treeNode = null;
        if (nums == null || nums.length == 0)
            return null;
        //找出最大值
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex == -1 || nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        treeNode = new TreeNode(nums[maxIndex]);
        //拆分数组
        int[] left = null;
        int[] right = null;
        if (maxIndex != 0)
            left = Arrays.copyOfRange(nums, 0, maxIndex);
        if (maxIndex != nums.length - 1)
            right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        treeNode.left = constructMaximumBinaryTree(left);
        treeNode.right = constructMaximumBinaryTree(right);
        return treeNode;
    }
}
