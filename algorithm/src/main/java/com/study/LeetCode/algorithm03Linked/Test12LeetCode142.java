package com.study.LeetCode.algorithm03Linked;

/**
 * 环形链表 II
 */
public class Test12LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fastIndex = head.next.next;
        ListNode slowIndex = head.next;
        //判断是否有环,如果无环，返回null
        while (slowIndex != fastIndex) {
            if (fastIndex == null || fastIndex.next == null)
                return null;
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        }
        //判断环的位置
        slowIndex = head;
        while (slowIndex != fastIndex) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }
        return slowIndex;

    }
}
