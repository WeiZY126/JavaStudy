package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class Test07LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //构建双端队列
        Deque<Integer> queue = new LinkedList<>();
        //构建结果数组
        int[] res = new int[nums.length - k + 1];

        //首先进入k个元素，填满窗口
        for (int i = 0; i < k; i++) {
            operateDeque(queue, nums, i, k);
        }

        //此时队头为滑动窗口的最大值
        int resIndex = 0;
        res[resIndex++] = queue.peekFirst();
        //开始剩余元素的遍历
        for (int i = k; i < nums.length; i++) {
            operateDeque(queue, nums, i, k);
            //此时队头为滑动窗口的最大值
            res[resIndex++] = queue.peekFirst();
        }
        return res;
    }

    public void operateDeque(Deque<Integer> queue, int[] nums, int i, int k) {
        //如果队列满了，或移动时移出窗口的元素等于队头，弹出队头
        if (queue.size() == k || (i >= k && nums[i - k] == queue.peekFirst()))
            queue.pollFirst();
        //当队列不为空，且当前值大于队尾，不满足单调队列，弹出队尾
        while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
            queue.pollLast();
        }
        //将当前元素加入队尾
        queue.addLast(nums[i]);
    }
}
