package com.study.LeetCode.algorithm03Linked;

/**
 * 删除排序链表中的重复元素 II
 */
public class Test10LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curIndex = head;

        while (curIndex != null&&curIndex.next != null) {
            if (curIndex.val == curIndex.next.val) {
                int x = curIndex.val;
                while (curIndex != null && curIndex.val == x) {
                    curIndex = curIndex.next;
                }
                prev.next = curIndex;
            } else {
                prev = prev.next;
                curIndex = curIndex.next;
            }
        }
        return dummyNode.next;
    }
}
