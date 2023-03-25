package com.study.LeetCode.algorithm03Linked;

/**
 * 链表的中间结点*
 */
public class Mar25LeetCode876 {
    /*快慢指针*/
    public ListNode LeetCode876(ListNode head) {
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex != null && fastIndex.next != null) {
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        }
        return slowIndex;
    }
}
