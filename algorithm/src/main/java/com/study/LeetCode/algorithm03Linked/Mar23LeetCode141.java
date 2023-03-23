package com.study.LeetCode.algorithm03Linked;

/**
 * 环形链表*
 */
public class Mar23LeetCode141 {
    /*快慢指针*/
    public boolean LeetCode141DoubleIndex(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex.next != null && fastIndex.next.next != null) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next.next;
            if (slowIndex == fastIndex)
                return true;
        }
        return false;
    }
}
