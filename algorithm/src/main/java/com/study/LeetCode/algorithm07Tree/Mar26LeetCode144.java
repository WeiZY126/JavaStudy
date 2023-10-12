package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历*
 */
public class Mar26LeetCode144 {
    public List<Integer> res = new ArrayList<>();

    /*进阶-迭代*/
    public List<Integer> LeetCode144Circulate(TreeNode root) {
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return res;
    }

    /*递归*/
    public List<Integer> LeetCode144Recursion(TreeNode root) {
        if (root == null)
            return res;
        res.add(root.val);
        if (root.left != null)
            LeetCode144Recursion(root.left);
        if (root.right != null)
            LeetCode144Recursion(root.right);
        return res;
    }
}
