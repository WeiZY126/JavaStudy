package com.study.LeetCode.algorithm03Linked;


/**
 * K个一组翻转链表
 */
public class Test17LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode nextNode = dummyNode;

        while (true) {
            for (int i = 0; i < k; i++) {
                nextNode = nextNode.next;
                if (nextNode == null)
                    return dummyNode.next;
            }
            ListNode tempNext = nextNode.next;
            nextNode.next = null;

            //翻转链表
            pre = reverseNodeList(pre);
            pre.next = tempNext;
            nextNode = pre;
        }

    }

    /**
     * 翻转链表
     * 返回链表尾结点，作为下一次的pre节点
     *
     * @param preNode
     */
    public ListNode reverseNodeList(ListNode preNode) {
        ListNode headNode = preNode.next;
        ListNode returnNode = headNode;
        ListNode pre = null;
        while (headNode != null) {
            ListNode tempNode = headNode.next;
            headNode.next = pre;
            pre = headNode;
            headNode = tempNode;
        }
        preNode.next = pre;
        return returnNode;
    }
}
