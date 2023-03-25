package com.study.LeetCode.algorithm03Linked;

/**
 * 反转链表*
 */
public class Mar23LeetCode206 {
    public ListNode LeetCode206(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        ListNode preNode = null;
        while (currentNode != null) {
            ListNode tempNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tempNode;
        }
        return preNode;
    }
}
