package com.study.LeetCode.algorithm03Linked;

/**
 * 环形链表2*
 */
public class Mar23LeetCode142 {
    /*快慢指针*/
    public ListNode LeetCode142DoubleIndex(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex.next != null && fastIndex.next.next != null) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next.next;
            //如果环存在
            if (slowIndex == fastIndex) {
                slowIndex = head;
                while (slowIndex != fastIndex) {
                    slowIndex = slowIndex.next;
                    fastIndex = fastIndex.next;
                }
                return slowIndex;
            }
        }
        return null;
    }
}
