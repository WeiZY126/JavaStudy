package com.study.LeetCode.algorithm07Tree;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Test10LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //构建哈希表，存储中序遍历的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //遍历前序遍历
        //第一个节点必定是根节点
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = treeNode;
            //判断下一个节点在当前节点的左边还是右边
            //如果中序遍历当前node值的坐标大于curNode坐标，则CurNode点为左子树，否则为右子树
            TreeNode curNode = new TreeNode(preorder[i]);
            while (true) {
                if (map.get(curNode.val) < map.get(node.val)) {
                    if (node.left == null) {
                        node.left = curNode;
                        break;
                    } else
                        node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = curNode;
                        break;
                    } else
                        node = node.right;
                }
            }
        }
        return treeNode;
    }
}
