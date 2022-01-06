package com.xmaven.task07;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 4:05 下午
 * @Version 1.0
 */
public class ThreadPriorityTest extends Thread {
    
    @Override
    public void run() {
        // System.out.println("子线程的优先级是:" + getPriority());
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程中：i = " + i);
        }
    }
    
    public static void main(String[] args) {
        ThreadPriorityTest test = new ThreadPriorityTest();
        test.start();
        Thread thread = Thread.currentThread();
        // System.out.println("主线程的优先级是:" + thread.getPriority()); // 5普通的优先级
        for (int i = 1; i <= 20; i++) {
            System.out.println("--------主线程中：i = " + i);
        }
    }
}
