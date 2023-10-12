package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历*
 */
public class Mar26LeetCode145 {
    public List<Integer> res = new ArrayList<>();

    /*进阶-迭代*/
    public List<Integer> LeetCode145Circulate(TreeNode root) {
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == preNode) {
                res.add(root.val);
                preNode = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /*递归*/
    public List<Integer> LeetCode145Recursion(TreeNode root) {
        if (root == null)
            return res;
        if (root.left != null)
            LeetCode145Recursion(root.left);
        if (root.right != null)
            LeetCode145Recursion(root.right);
        res.add(root.val);
        return res;
    }
}
