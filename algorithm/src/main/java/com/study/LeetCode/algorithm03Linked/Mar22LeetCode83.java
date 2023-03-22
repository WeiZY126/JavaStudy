package com.study.LeetCode.algorithm03Linked;

/**
 * 删除排序链表中的重复元素*
 */
public class Mar22LeetCode83 {

    /*双指针*/
    public ListNode LeetCode83DoubleIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preNode = head;
        ListNode nextNode = head.next;
        while (preNode != null) {
            while (nextNode != null && nextNode.val == preNode.val) {
                nextNode = nextNode.next;
            }
            preNode.next = nextNode;
            preNode = preNode.next;
        }
        return head;
    }

    /*递归*/
    public ListNode LeetCode83Recursion(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null || head.val == head.next.val) {
            head.next = LeetCode83Recursion(head.next);
            return head.next;
        } else {
            return head;
        }
    }
}
