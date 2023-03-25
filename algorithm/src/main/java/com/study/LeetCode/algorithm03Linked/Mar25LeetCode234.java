package com.study.LeetCode.algorithm03Linked;

/**
 * 回文链表*
 */
public class Mar25LeetCode234 {
    /*快慢指针+反转链表*/
    public boolean LeetCode234(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex != null && fastIndex.next != null) {
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        }
        //判断奇偶
        if (fastIndex != null)
            slowIndex = slowIndex.next;
        //反转慢指针
        ListNode currentNode = slowIndex;
        ListNode preNode = null;
        while (currentNode != null) {
            ListNode tempNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tempNode;
        }

        slowIndex = preNode;
        fastIndex = head;
        //此时 slowIndex为反转的后半段链表，fastIndex为前半段
        //判断两个链表是否相等
        while (slowIndex != null) {
            if (slowIndex.val != fastIndex.val)
                return false;
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }
        return true;
    }
}
