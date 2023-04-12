package com.studyDesignPattern01Singleton;

/**
 * 枚举式
 */
public class Singleton07Enum {
    public enum Singleton {
        INSTANCE;

        public void showMessage() {
            System.out.println("hello world");
        }
    }

    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton.INSTANCE.showMessage();
        }
    }
}
