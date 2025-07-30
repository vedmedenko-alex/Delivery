package com.solvd.delivery.classes.ThreadsSandBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadsSandBox {
    private static final Logger logger = LoggerFactory.getLogger(ThreadsSandBox.class);

    public static class Singleton {
        public static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if(instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        public void logThreadName() {
            logger.info(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            singleton.logThreadName();
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");
        Thread thread4 = new Thread(task, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
