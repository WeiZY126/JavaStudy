package com.study.LeetCode;//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类：
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 10⁵
// 最多调用 2 * 10⁵ 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2276 👎 0


import java.util.concurrent.ConcurrentHashMap;

public class LeetCode146LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private int capacity;
    private int count;
    private DLinkNode head, tail;
    private ConcurrentHashMap<Integer, DLinkNode> concurrentHashMap = new ConcurrentHashMap<>();

    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode dLinkNode = concurrentHashMap.get(key);
        if (dLinkNode == null) {
            return -1;
        }
        if (dLinkNode == head.next) {
            return dLinkNode.value;
        } else {
            //将节点取出
            dLinkNode.prev.next = dLinkNode.next;
            dLinkNode.next.prev = dLinkNode.prev;
            //将节点加入head后
            dLinkNode.next = head.next;
            dLinkNode.prev = head;
            head.next.prev = dLinkNode;
            head.next = dLinkNode;
            return dLinkNode.value;
        }
    }

    private void delLink(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        concurrentHashMap.put(node.key, node);
    }

    private void delLast() {
        DLinkNode lastNode = tail.prev;
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
        concurrentHashMap.remove(lastNode.key);
    }

    public void put(int key, int value) {
        DLinkNode node = new DLinkNode(key, value);
        if (count < capacity) {
            if (!concurrentHashMap.containsKey(key)) {
                insertHead(node);
                count++;
            } else {
                node = concurrentHashMap.get(key);
                node.value = value;
                delLink(node);
                insertHead(node);
            }
        } else {
            if (!concurrentHashMap.containsKey(key)) {
                delLast();
                insertHead(node);
            } else {
                node = concurrentHashMap.get(key);
                node.value = value;
                delLink(node);
                insertHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
