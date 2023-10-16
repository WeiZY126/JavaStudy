package com.study.LeetCode.algorithm09Search;

/**
 * 寻找两个正序数组的中位数
 */
public class Test03LeetCode4 {
    public static void main(String[] args) {
        new Test03LeetCode4().findMedianSortedArrays(new int[]{1,3},new int[]{2});
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;

        //交换两个数组
        if (n1Length > n2Length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            n1Length = nums1.length ;
            n2Length = nums2.length ;
        }

        //设置两个切割指针
        int cut1 = 0;
        int cut2 = 0;

        // 1、 ( nums1 的左部分 + nums2 的左部分 ）个数 = （ nums1 的右部分 + nums2 的右部分 ）个数】
        // 2、( nums1 的左部分 + nums2 的左部分 ）最大数 <= （ nums1 的右部分 + nums2 的右部分 ）最小数
        int n1Min = 0;
        int n2Min = 0;
        int n1Max = 0;
        int n2Max = 0;

        // 由于 m + n 可能为奇数, 也可能为偶数，为了方便统一处理，这里加入一个技巧
        // 在数组的 开头、结尾、数字直接加入一个 “#”
        // 这样 nums2 的长度 m 变成了 2m + 1
        // 这样 nums1 的长度 n 变成了 2n + 1
        // 两数之和变成了 2m + 2n + 2，恒为偶数
        // 比如 [ 1 、3 、5 、7 ] 变成了 [ #、 1 、# 、3 、 # 、5  、 # 、7 、# ]
        // 比如 [ 2 、4 、6 ] 变成了 [ #、 2 、# 、4 、 # 、6  、 #  ]
        // 因此，每个位置的下标位置发生了改变，但可以通过 /2 得到原来元素的位置：
        // 比如 1，原来在 0 位，现在是 1 位，1 / 2 = 0
        // 比如 3，原来在 1 位，现在是 3 位，3 / 2 = 1
        // 比如 6，原来在 2 位，现在是 5 位，5 / 2 = 2

        int left = 0;
        //right下标为2倍num1长度
        int right = 2 * n1Length;

        while (left <= right) {
            cut1 = left + (right - left) / 2;
            //num左边元素数量等于右边元素数量，cut1+cut2 = (2m+2n)/2;
            cut2 = n1Length + n2Length - cut1;

            //在最左边
            if (cut1 == 0) {
                n1Max = Integer.MIN_VALUE;
            } else {
                //左边元素下标为(cut1-1)/2
                n1Max = nums1[(cut1 - 1) / 2];
            }

            //在最右边
            if (cut1 == n1Length * 2) {
                n1Min = Integer.MAX_VALUE;
            } else {
                //右侧元素下标为cut1/2
                n1Min = nums1[cut1 / 2];
            }

            //cut2在最左边
            if (cut2 == 0) {
                n2Max = Integer.MIN_VALUE;
            } else {
                n2Max = nums2[(cut2 - 1) / 2];
            }

            //cut2在最右边
            if (cut2 == n2Length * 2) {
                n2Min = Integer.MAX_VALUE;
            } else {
                n2Min = nums2[cut2 / 2];
            }

            if (n1Max > n2Min) {
                //num1左侧太大了，cut1需要左移
                right = cut1 - 1;
            } else if (n2Max > n1Min) {
                //num2左侧太大，cut1需要右移
                left = cut1 + 1;
            } else {
                break;
            }
        }

        return (Math.max(n1Max, n2Max) + Math.min(n1Min, n2Min)) / 2.0;
    }
}