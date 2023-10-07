package com.study.LeetCode.algorithm03Linked;

/**
 * 重排链表
 */
public class Test06LeetCode143 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode1.val = 1;
        listNode2.val = 2;
        listNode3.val = 3;
        listNode4.val = 4;
        listNode5.val = 5;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new Test06LeetCode143().reorderList(listNode1);
    }

    //双指针
    public void reorderList(ListNode head) {
        if (head == null && head.next == null)
            return;
        //找到链表的中点
        ListNode fastNode = head;
        ListNode midNode = head;
        while (fastNode.next != null) {
            fastNode = fastNode.next.next;
            midNode = midNode.next;
        }

        ListNode curNode = midNode.next;
        midNode.next = null;

        //翻转右链表
        ListNode preNode = null;
        while (curNode != null) {
            ListNode curTmp = curNode;
            curNode = curNode.next;
            curTmp.next = preNode;
            preNode = curTmp;
        }

        //拼接两条链表
        while (head != null && preNode != null) {
            ListNode tmpHead = head;
            head = head.next;
            tmpHead.next = preNode;
            ListNode tmpPreNode = preNode;
            preNode = preNode.next;
            tmpPreNode.next = head;
        }
    }
}
