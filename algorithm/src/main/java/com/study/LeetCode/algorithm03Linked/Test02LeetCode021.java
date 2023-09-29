package com.study.LeetCode.algorithm03Linked;

/**
 * 合并两个有序链表
 */
public class Test02LeetCode021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        ListNode index1 = list1;
        ListNode index2 = list2;
        ListNode head = new ListNode();
        head.next = list1;
        ListNode preNode = head;
        while (index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                preNode.next = index1;
                //index1向后移动
                index1 = index1.next;
            } else {
                preNode.next = index2;
                //index2向后移动
                index2 = index2.next;
            }
            preNode = preNode.next;
        }

        //判断剩余的节点
        if (index2 != null) {
            preNode.next = index2;
        } else if (index1 != null) {
            preNode.next = index1;
        }
        return head.next;
    }
}
