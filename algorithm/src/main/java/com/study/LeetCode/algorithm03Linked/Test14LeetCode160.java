package com.study.LeetCode.algorithm03Linked;

/**
 * 相交链表
 */
public class Test14LeetCode160 {
    /**
     * 改良版
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode IndexA = headA;
        ListNode IndexB = headB;

        /**
         * 如果不存在链，交换后两个指针最后都会指向null
         */
        while (IndexA != IndexB) {
            IndexA = IndexA == null ? headB : IndexA.next;
            IndexB = IndexB == null ? headA : IndexB.next;
        }
        return IndexA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode IndexA = headA;
        ListNode IndexB = headB;

        while (IndexA != null || IndexB != null) {
            if (IndexA == IndexB)
                return IndexA;
            if (IndexA == null) {
                IndexA = headB;
                IndexB = IndexB.next;
            } else if (IndexB == null) {
                IndexB = headA;
                IndexA = IndexA.next;
            } else {
                IndexA = IndexA.next;
                IndexB = IndexB.next;
            }
        }
        return null;
    }
}
