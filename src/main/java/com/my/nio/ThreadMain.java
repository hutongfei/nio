package com.my.nio;

import org.openjdk.jol.info.ClassLayout;

public class ThreadMain {
    // 每个线程都具有获取获取独立变量的能力，之间互不影响
    private static ThreadLocal<Integer> local = new ThreadLocal();

    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object) {
            String ss = ClassLayout.parseInstance(object).toPrintable();
            System.out.println(">    lock ");
            System.out.println(ss);
        }
        System.out.println(">    unlock ");
        String ss = ClassLayout.parseInstance(object).toPrintable();
        System.out.println(ss);
    }
}
