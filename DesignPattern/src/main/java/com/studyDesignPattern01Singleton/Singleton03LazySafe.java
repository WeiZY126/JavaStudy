package com.studyDesignPattern01Singleton;

/**
 * 懒汉式线程安全
 */
public class Singleton03LazySafe {
    public static class Singleton {
        private static Singleton singleton;

        private Singleton() {
        }

        public static synchronized Singleton getInstance() {
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
            Singleton03LazySafe.Singleton.getInstance().showMessage();
        }
    }
}
