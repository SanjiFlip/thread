package com.xmaven.task07;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 4:05 下午
 * @Version 1.0
 */
public class ThreadPriorityTest3 extends Thread {
    
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程中：i = " + i);
        }
    }
    
    public static void main(String[] args) {
        ThreadPriorityTest3 test = new ThreadPriorityTest3();
        // 设置子线程优先级
        // 注意点， 优先级越高的线程不一定先执行，但是该线程获取到的时间片的机会会更多一些
        test.setPriority(Thread.MAX_PRIORITY);
        test.start();
        Thread thread = Thread.currentThread();
        for (int i = 1; i <= 20; i++) {
            System.out.println("------主线程中：i = " + i);
        }
    }
}
