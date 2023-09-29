package com.study.LeetCode.algorithm03Linked;

/**
 * 链表的中间结点
 */
public class Test01LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
