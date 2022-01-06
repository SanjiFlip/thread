package com.xmaven.task08;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 4:19 下午
 * @Version 1.0
 */
public class ThreadJoinTest extends Thread {
    
    @Override
    public void run() {
        System.out.println("倒计时开始...");
        // 模拟倒数10个数
        for (int i = 10; i > 0; i--) {
            System.out.println("倒计时:" + i + " s");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("倒计时完毕...");
    }
    
    
    public static void main(String[] args) {
        ThreadJoinTest test = new ThreadJoinTest();
        test.start();
        // 主线程开始等待
        System.out.println("主线程开始等待...");
        try {
            // 当前正在执行的线程对象等待调用线程对象，也就是主线程等待子线程执行终止
            // test.join();
            // 主线程等待子线程执行5s（最多等待5s）后，主线程开始执行
            test.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待结束...");
    }
}
