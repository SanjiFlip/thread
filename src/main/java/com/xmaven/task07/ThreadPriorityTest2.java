package com.xmaven.task07;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 4:05 下午
 * @Version 1.0
 */
public class ThreadPriorityTest2 extends Thread {
    
    @Override
    public void run() {
        System.out.println("子线程的优先级是:" + getPriority());
    }
    
    public static void main(String[] args) {
        ThreadPriorityTest2 test = new ThreadPriorityTest2();
        // 设置子线程优先级
        test.setPriority(Thread.MAX_PRIORITY);
        test.start();
        Thread thread = Thread.currentThread();
        System.out.println("主线程的优先级是:" + thread.getPriority());
    }
}
