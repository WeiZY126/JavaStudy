package com.study.LeetCode.algorithm03Linked;

/**
 * 两两交换链表中的节点
 */
public class Test08LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode preIndex = preHead;
        ListNode leftIndex = head;
        ListNode rightIndex = head.next;
        while (rightIndex != null) {
            ListNode tmpRight = rightIndex;
            ListNode tmpLeft = leftIndex;
            preIndex.next = rightIndex;
            if (rightIndex.next == null)
                rightIndex = rightIndex.next;
            else
                rightIndex = rightIndex.next.next;
            leftIndex = leftIndex.next.next;
            tmpRight.next = tmpLeft;
            tmpLeft.next = leftIndex;
            preIndex = preIndex.next.next;
        }
        return preHead.next;
    }
}
