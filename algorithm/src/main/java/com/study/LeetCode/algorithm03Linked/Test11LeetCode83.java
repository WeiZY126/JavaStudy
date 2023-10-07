package com.study.LeetCode.algorithm03Linked;

/**
 * 删除排序链表中的重复元素
 */
public class Test11LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curIndex = head;

        while (curIndex != null && curIndex.next != null) {
            if (curIndex.val == curIndex.next.val) {
                curIndex.next = curIndex.next.next;
            } else {
                curIndex = curIndex.next;
            }
        }
        return head;
    }
}
