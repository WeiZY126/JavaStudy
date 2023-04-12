package com.studyDesignPattern01Singleton;

/**
 * 饿汉模式
 */
public class Singleton02Lazy {
    public static class Singleton {
        private static Singleton singleton;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (singleton == null)
                return new Singleton();
            return singleton;
        }

        public void showMessage() {
            System.out.println("hello world");
        }
    }

    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton02Lazy.Singleton.getInstance().showMessage();
        }
    }
}
