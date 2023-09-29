package com.study.LeetCode.algorithm03Linked;

/**
 * 排序链表
 */
public class Test04LeetCode148 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode1.val = -1;
        listNode2.val = 5;
        listNode3.val = 3;
        listNode4.val = 4;
        listNode5.val = 0;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new Test04LeetCode148().sortList(listNode1);
    }

    /**
     * 自底向上，空间O(1)
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = new ListNode();
        prev.next = head;
        //记录原始虚拟头结点
        ListNode prevHead = prev;

        //计算链表长度
        int subLength = 0;
        while (head != null) {
            head = head.next;
            subLength++;
        }

        //自底向上
        for (int step = 1; step <= subLength; step *= 2) {
            prev = prevHead;
            ListNode nextNode = null;
            ListNode cur = prevHead;
            //当cur不为空时,开始循环操作
            while (cur != null) {
                //1.制作左子链表，链表长度为step,链表头为head1
                ListNode leftHead = prev;
                for (int i = 0; i < step; i++) {
                    if (cur != null)
                        cur = cur.next;
                }
                ListNode leftLastNode = cur;
                //2.制作左子链表，链表长度为step,链表头为rightHead,尾为rightLastNode
                ListNode rightHead = null;
                if (cur != null)
                    rightHead = cur.next;
                for (int i = 0; i < step; i++) {
                    if (cur != null)
                        cur = cur.next;
                }
                ListNode rightLastNode = cur;
                //3.制作下一次开始的节点，节点头为nextNode
                if (cur != null)
                    nextNode = cur.next;
                //4.断开左右子链表的后端
                if (leftLastNode != null)
                    leftLastNode.next = null;
                if (rightLastNode != null)
                    rightLastNode.next = null;
                //5.开始合并，合并后的尾节点赋给prev
                prev = sortTwoList(leftHead, rightHead);
                //6.将当前cur置为下一次的next
                cur = nextNode;
                //7.连接prev与下一次头结点
                prev.next = nextNode;

                //制作右子链表,链表长度为step
                //1.移动next节点，使其落在下一次需要合并的位置
                for (int j = 0; j < step; j++) {
                    if (nextNode != null)
                        nextNode = nextNode.next;
                }
                //创建tmpCur,准备作为右子链表的头结点
                ListNode rightCur = prev;
                //获取此次阶段的中间结点，即步长为2，则中间节点为1
                int tmpMid = step / 2;
                while (tmpMid-- > 0) {
                    if (rightCur != null)
                        rightCur = rightCur.next;
                }
                //2.开始移动cur，落在nextNode节点的前一个
                while (cur.next != nextNode) {
                    cur = cur.next;
                }
                //3.断开cur节点和rightCur节点后的节点，准备进行合并
                cur.next = null;
                ListNode tmpCur = null;
                if (rightCur != null && rightCur != prev) {
                    tmpCur = rightCur.next;
                    rightCur.next = null;
                }
                //此时，prev为带虚拟头的左子节点，tmpCur为右子节点的头
                //4.根据prev节点和tmpCur节点，合并链表,并将prev放在链表尾，准备下一次合并
                prev = sortTwoList(prev, tmpCur);
                //6.移动cur节点到nextNode节点，准备下次合并
                cur = nextNode;
                //7.连接prev节点到新的cur节点
                prev.next = cur;
            }
        }
        return prevHead.next;
    }

    public ListNode sortTwoList(ListNode pre, ListNode rightNode) {
        ListNode leftNode = pre.next;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                pre.next = leftNode;
                leftNode = leftNode.next;
                pre = pre.next;
            } else {
                pre.next = rightNode;
                rightNode = rightNode.next;
                pre = pre.next;
            }
        }
        //合并剩余链表
        if (leftNode != null) {
            pre.next = leftNode;
        } else if (rightNode != null) {
            pre.next = rightNode;
        }
        while (pre.next != null)
            pre = pre.next;
        //返回链表尾
        return pre;
    }


    /**
     * 递归 自顶向下，空间O(nlogn)
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //计算节点的中点的前一个节点
        ListNode middleNode = getMiddleNode(head);
        //断开middleNode，即左链和右链
        ListNode tmp = middleNode.next;
        middleNode.next = null;
        middleNode = tmp;
        //递归拆分左链右链，然后排序
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(middleNode);
        //排序左右链为新链表
        ListNode after = sortTwoList(leftNode, rightNode);
        return after;
    }

    public ListNode sortTwoList2(ListNode leftNode, ListNode rightNode) {
        ListNode head = new ListNode();
        ListNode pre = head;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                pre.next = leftNode;
                leftNode = leftNode.next;
                pre = pre.next;
            } else {
                pre.next = rightNode;
                rightNode = rightNode.next;
                pre = pre.next;
            }
        }
        //合并剩余链表
        if (leftNode != null) {
            pre.next = leftNode;
        } else if (rightNode != null) {
            pre.next = rightNode;
        }
        return head.next;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        int num = 0;
        while (head != null) {
            head = head.next;
            num++;
        }
        num = num / 2;
        while (num-- > 0) {
            tmpHead = tmpHead.next;
        }
        return tmpHead == null ? head : tmpHead;
    }
}
