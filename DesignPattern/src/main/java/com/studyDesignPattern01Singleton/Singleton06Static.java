package com.studyDesignPattern01Singleton;

/**
 * 登记式/静态内部类式
 */
public class Singleton06Static {
    public static class Singleton {
        private static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }

        private Singleton() {
        }

        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }

        public void showMessage() {
            System.out.println("hello world");
        }
    }

    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton06Static.Singleton.getInstance().showMessage();
        }
    }
}
