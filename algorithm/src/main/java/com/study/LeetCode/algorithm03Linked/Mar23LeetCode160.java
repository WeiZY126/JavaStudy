package com.study.LeetCode.algorithm03Linked;

/**
 * 相交链表*
 */
public class Mar23LeetCode160 {
    /*双指针*/
    public ListNode LeetCode160DoubleIndex(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode IndexA = headA;
        ListNode IndexB = headB;
        while (IndexA != IndexB) {
            IndexA = IndexA == null ? headB : IndexA.next;
            IndexB = IndexB == null ? headA : IndexB.next;
        }
        return IndexA;

    }

    /*双指针，长度差*/
    public ListNode LeetCode160DoubleIndexLength(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode IndexA = headA;
        ListNode IndexB = headB;
        Integer lengthA = 0;
        Integer lengthB = 0;
        while (IndexA != null) {
            IndexA = IndexA.next;
            lengthA++;
        }
        while (IndexB != null) {
            IndexB = IndexB.next;
            lengthB++;
        }
        IndexA = headA;
        IndexB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                IndexA = IndexA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                IndexB = IndexB.next;
            }
        }
        while (IndexA != IndexB) {
            IndexA = IndexA.next;
            IndexB = IndexB.next;
        }
        return IndexA;
    }

    /*双指针2*/
    public ListNode LeetCode160DoubleIndex2(ListNode headA, ListNode headB) {
        ListNode IndexA = headA;
        ListNode IndexB = headB;
        while (IndexA != null || IndexB != null) {
            if (IndexA == null)
                IndexA = headB;
            if (IndexB == null)
                IndexB = headA;
            if (IndexA == IndexB)
                return IndexA;
            IndexA = IndexA.next;
            IndexB = IndexB.next;
        }
        return null;
    }
}
