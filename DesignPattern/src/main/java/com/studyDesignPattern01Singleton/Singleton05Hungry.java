package com.studyDesignPattern01Singleton;

/**
 * 饿汉式
 */
public class Singleton05Hungry {
    public static class Singleton {
        private static Singleton singleton;
        static {
            singleton = new Singleton();
        }

        private Singleton() {
        }

        public static synchronized Singleton getInstance() {
            return singleton;
        }

        public void showMessage() {
            System.out.println("hello world");
        }
    }

    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton05Hungry.Singleton.getInstance().showMessage();
        }
    }
}
