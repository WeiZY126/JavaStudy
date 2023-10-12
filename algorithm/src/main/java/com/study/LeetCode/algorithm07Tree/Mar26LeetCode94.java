package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历*
 */
public class Mar26LeetCode94 {
    public List<Integer> res = new ArrayList<>();

    /*进阶-迭代*/
    public List<Integer> LeetCode94Circulate(TreeNode root) {
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            //遍历到最左边
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //取出栈顶元素
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /*递归*/
    public List<Integer> LeetCode94Recursion(TreeNode root) {
        if (root == null)
            return res;
        if (root.left != null)
            LeetCode94Recursion(root.left);
        res.add(root.val);
        if (root.right != null)
            LeetCode94Recursion(root.right);
        return res;
    }
}
