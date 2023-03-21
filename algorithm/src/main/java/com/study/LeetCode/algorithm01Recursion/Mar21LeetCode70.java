package com.study.LeetCode.algorithm01Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯*
 * f(1)=1
 * f(2)=2*
 * f(n)=f(n-1)+f(n-2)*
 * 终止条件:(1)只有一个楼梯的时候,只有一种走法，(2)只有两个楼梯的时候，只有两种走法*
 */
public class Mar21LeetCode70 {
    private Map<Integer, Integer> storeMap = new HashMap<>();

    /*递归解法 O(n^2)*/
    public int leetCode70Recursion(int n) {
        //终止条件
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        //判断hashMap是否有该值，有的话返回，没有的话计算后放入
        //时间复杂度O(n)
        if (storeMap.get(n) != null) {
            return storeMap.get(n);
        } else {
            int res = leetCode70Recursion(n - 1) + leetCode70Recursion(n - 2);
            storeMap.put(n, res);
            return res;
        }
    }

    /*循环解法 O(n)*/
    public int leetCode70Circulate(int n) {
        int sum = 0;
        //前一次的中间过程
        int lastSum = 2;
        //前两次的中间过程
        int lastLastSum = 1;
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        for (int i = 3; i <= n; i++) {
            sum = lastSum + lastLastSum;
            lastLastSum = lastSum;
            lastSum = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Mar21LeetCode70().leetCode70Recursion(10));
        System.out.println(new Mar21LeetCode70().leetCode70Circulate(10));
    }
}
