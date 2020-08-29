package com.my.nio;

public class ManyThread implements Runnable {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public ManyThread(ThreadLocal<Integer> threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            threadLocal.set(threadLocal.get() == null ? 0 : threadLocal.get() + 1);
            System.out.println(Thread.currentThread().getName() + "  ->  " + threadLocal.get());
        }
    }
}
