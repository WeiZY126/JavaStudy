package com.study.LeetCode.algorithm03Linked;

/**
 * 合并有序链表
 * 热度 字节、美团、快手、腾讯、京东* *
 */
public class Mar22LeetCode21 {
    /*双指针*/
    public ListNode LeetCode21DoubleIndex(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        //处理非空剩余节点
        if (l1 != null) temp.next = l1;
        else if (l2 != null) temp.next = l2;
        return head.next;
    }

    /*递归*/
    public ListNode LeetCode21Recursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = LeetCode21Recursion(l1.next, l2);
            return l1;
        } else {
            l2.next = LeetCode21Recursion(l1, l2.next);
            return l2;
        }
    }

    /*递归*/
    ListNode head = new ListNode();
    ListNode temp = head;

    public ListNode LeetCode21Recursion2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            temp.next = l2;
            return head.next;
        } else if (l2 == null) {
            temp.next = l1;
            return head.next;
        }
        if (l1.val <= l2.val) {
            temp.next = l1;
            temp = temp.next;
            return LeetCode21Recursion2(temp.next, l2);
        } else {
            temp.next = l2;
            temp = temp.next;
            return LeetCode21Recursion2(l1, temp.next);
        }
    }
}
