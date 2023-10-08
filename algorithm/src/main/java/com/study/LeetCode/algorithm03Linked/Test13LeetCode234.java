package com.study.LeetCode.algorithm03Linked;

/**
 * 回文链表
 */
public class Test13LeetCode234 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode1.val = 1;
        listNode2.val = 1;
        listNode3.val = 2;
        listNode4.val = 1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(new Test13LeetCode234().isPalindrome(listNode1));
    }
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        //快慢指针找到中点
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        //此时,slowNode为中间节点的前一个
        fastNode = slowNode.next;
        //断开链表
        slowNode.next = null;
        //翻转后半段链表
        ListNode pre = null;
        while (fastNode != null) {
            ListNode tmpNext = fastNode.next;
            fastNode.next = pre;
            pre = fastNode;
            fastNode = tmpNext;
        }

        //此时,slowNode为前半段链表头
        slowNode = head;
        //fastNode为后半段链表头
        while (fastNode != null) {
            if (slowNode.val != fastNode.val)
                return false;
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return true;
    }
}
