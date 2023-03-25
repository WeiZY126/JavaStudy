package com.study.LeetCode.algorithm03Linked;

/**
 * 链表中倒数第K个节点*
 */
public class Mar25Offer22 {
    public ListNode Offer22(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        for (int i = 0; i < k - 1; i++) {
            fastIndex = fastIndex.next;
            //判定边界
            if (fastIndex == null)
                return null;
        }
        while (fastIndex.next != null) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }
        return slowIndex;

    }
}
