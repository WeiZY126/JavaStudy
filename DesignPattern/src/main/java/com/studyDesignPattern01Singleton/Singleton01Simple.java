package com.studyDesignPattern01Singleton;

/**
 * 简单单例模式
 */
public class Singleton01Simple {
    static class Singleton {
        private static Singleton singleton = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return singleton;
        }

        public void showMessage(){
            System.out.println("hello world");
        }
    }
    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton01Simple.Singleton.getInstance().showMessage();
        }
    }
}
