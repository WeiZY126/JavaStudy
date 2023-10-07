package com.study.LeetCode.algorithm03Linked;

public class Test07LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        //计算链表的长度
        ListNode tmpHead = head;
        int length = 0;
        while (tmpHead != null) {
            tmpHead = tmpHead.next;
            length++;
        }

        //取模，取出旋转的次数
        int numK = k % length;

        //计算出头结点
        ListNode fastIndex = head.next;
        for (int i = 0; i < numK; i++) {
            //fastIndex多移动一格，需要断开链表
            fastIndex = fastIndex.next;
        }
        ListNode preHead = head;
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            preHead = preHead.next;
        }

        ListNode newHead = preHead.next;
        preHead.next = null;

        if (newHead == null) {
            return head;
        }
        //连接链表
        fastIndex = newHead;
        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
        }
        fastIndex.next = head;
        return newHead;
    }
}
