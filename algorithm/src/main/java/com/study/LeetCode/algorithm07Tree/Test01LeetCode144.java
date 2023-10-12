package com.study.LeetCode.algorithm07Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class Test01LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //结果集
        List<Integer> res = new ArrayList<>();
        //定义栈
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        //标记状态，0为left，1为right，2为up
        int status = 0;
        while (node != null) {
            if (status == 0) {
                res.add(node.val);
                //状态为left状态
                if (node.left != null) {
                    //栈中加入当前节点
                    stack.push(node);

                    node = node.left;
                } else {
                    //切换状态到右状态
                    status = 1;
                }
            } else if (status == 1) {
                //状态为right状态
                if (node.right != null) {
                    //栈中加入当前节点
                    stack.push(node);

                    node = node.right;
                    //子节点遍历，需要从左状态开始遍历
                    status = 0;
                } else {
                    //切换状态到up状态
                    status = 2;
                }
            } else {
                TreeNode parent = null;
                if (!stack.isEmpty()) {
                    parent = stack.pop();
                    if (parent.left == node) {
                        //如果当前节点是父节点的左子节点，需要把状态置为right
                        status = 1;
                    }
                    //如果当前节点是父节点的右子节点，直接把父节点赋给当前节点，状态不修改
                }
                node = parent;
            }
        }
        return res;
    }
}
