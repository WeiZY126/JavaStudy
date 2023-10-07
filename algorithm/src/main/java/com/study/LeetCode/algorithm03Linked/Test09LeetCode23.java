package com.study.LeetCode.algorithm03Linked;

/**
 * 合并K个升序链表
 */
public class Test09LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int length = lists.length;
        for (int i = 1; i < length; i *= 2) {
            for (int i1 = 0; i1 < length; i1 += i) {
                ListNode leftList = lists[i1];
                i1 += i;
                if (i1 >= length)
                    break;
                ListNode rightList = lists[i1];
                //合并两个链表
                lists[i1 - i] = mergeTwoLists(leftList, rightList);
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
        ListNode preNode = new ListNode();
        ListNode headNode = preNode;
        while (leftList != null && rightList != null) {
            if (leftList.val <= rightList.val) {
                preNode.next = leftList;
                leftList = leftList.next;
                preNode = preNode.next;
            } else {
                preNode.next = rightList;
                rightList = rightList.next;
                preNode = preNode.next;
            }
        }
        if (leftList != null) {
            preNode.next = leftList;
        } else if (rightList != null) {
            preNode.next = rightList;
        }

        return headNode.next;
    }
}
