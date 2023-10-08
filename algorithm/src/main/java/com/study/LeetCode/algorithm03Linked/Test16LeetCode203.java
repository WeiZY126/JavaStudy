package com.study.LeetCode.algorithm03Linked;

public class Test16LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        while (pre != null && pre.next != null) {
            if (pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }
        return preHead.next;
    }
}
