package com.study.LeetCode.algorithm12Greedy;

/**
 * 种花问题
 */
public class Test07LeetCode605 {
    public static void main(String[] args) {
        new Test07LeetCode605().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0)
            return n - 1 <= 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            } else if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                i += 3;
                continue;
            } else {
                if (flowerbed[i] == 0) {
                    if ((i == 0)
                            || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0)
                            || (i > 0 && i < flowerbed.length - 1 && flowerbed[i - 1] == 0)) {
                        n--;
                        i += 2;
                        continue;
                    }
                }
                i++;
            }
        }
        return n <= 0;
    }
}
