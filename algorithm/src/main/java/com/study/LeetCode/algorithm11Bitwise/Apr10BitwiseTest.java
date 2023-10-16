package com.study.LeetCode.algorithm11Bitwise;

public class Apr10BitwiseTest {
    public static void main(String[] args) {
        System.out.println("4:" + Integer.toBinaryString(4));
        System.out.println("6:" + Integer.toBinaryString(6));
        System.out.println("4&6:" + Integer.toBinaryString(4 & 6));
        System.out.println("4&6:" + Integer.toBinaryString(4 | 6));
        System.out.println("4&6:" + Integer.toBinaryString(4 ^ 6));
        System.out.println("~4:" + Integer.toBinaryString(~4));
        //如果两个数一样，异或一定相同
        System.out.println("~4:" + Integer.toBinaryString(100 ^ 100));

        System.out.println("4>>1:" + Integer.toBinaryString(4 >> 1));
        System.out.println("-4:" + Integer.toBinaryString(-4));
        System.out.println("-4>>1:" + Integer.toBinaryString(-4 >> 1));
        System.out.println("4<<1:" + Integer.toBinaryString(4 << 1));
        System.out.println("-4>>>1:" + Integer.toBinaryString(-4 >>> 1));

    }
}
