package com.study.LeetCode.algorithm02Array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 热度 字节、美团、快手* *
 */
public class Mar21LeetCode88 {

    /*Arrays方法,快速排序O(m+n)log(m+n)*/
    public void leetCode88Arrays(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /*双指针 时间复杂度O(m+n)，空间复杂度O(m+n)*/
    public void leetCode88DoubleIndex(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[m + n];
        for (int nums1Index = 0, nums2Index = 0, tempIndex = 0; tempIndex < k; tempIndex++) {
            if (nums1Index >= m)
                temp[tempIndex] = nums2[nums2Index++];
            else if (nums2Index >= n)
                temp[tempIndex] = nums1[nums1Index++];
            else if (nums1[nums1Index] <= nums2[nums2Index])
                temp[tempIndex] = nums1[nums1Index++];
            else if (nums2[nums2Index] <= nums1[nums1Index])
                temp[tempIndex] = nums2[nums2Index++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    /*倒序双指针*/
    public void leetCode88DoubleIndexReverse(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int k = m + n + 1; k >= 0; k--) {
            if (m < 0)//nums1遍历完，将剩余nums2放入
                nums1[k] = nums2[n--];
            else if (n < 0)//nums2遍历完，结束
                break;
            else if (nums1[m] <= nums2[n])
                nums1[k] = nums2[n--];
            else if (nums1[m] > nums2[n])
                nums1[k] = nums1[m--];
        }
    }
}
