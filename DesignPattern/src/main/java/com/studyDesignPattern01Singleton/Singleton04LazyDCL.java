package com.studyDesignPattern01Singleton;

/**
 * DCL(double-checked locking)懒汉式
 */
public class Singleton04LazyDCL {
    public static class Singleton {
        private static Singleton singleton;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null)
                        return new Singleton();
                }
            }
            return singleton;
        }

        public void showMessage() {
            System.out.println("hello world");
        }
    }

    static class SingletonDemo {
        public static void main(String[] args) {
            Singleton04LazyDCL.Singleton.getInstance().showMessage();
        }
    }
}
