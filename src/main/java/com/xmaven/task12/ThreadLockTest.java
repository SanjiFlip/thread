package com.xmaven.task12;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Ambition
 * @Description TODO ReentrantLock实现加锁
 * @Date: 2022/1/7 5:42 下午
 * @Version 1.0
 */
public class ThreadLockTest implements Runnable {
    
    // 用于描述账户余额
    private int balance;
    
    // 准备一把锁
    private ReentrantLock lock = new ReentrantLock();
    
    public ThreadLockTest() {
    }
    
    public ThreadLockTest(int balance) {
        this.balance = balance;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    @Override
    public void run() {
        // 开始加锁
        lock.lock();
        
        System.out.println("子线程：" + Thread.currentThread().getName() + "-启动...");
        // 1.模拟冲后台查询账户余额的过程
        int temp = getBalance();
        // 2.模拟取款200元的过程
        if (temp >= 200) {
            System.out.println("正在出钞，请稍后...");
            temp -= 200;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("请取走您的钞票...");
        } else {
            System.out.println("余额不足，请核对您的账户余额值!");
        }
        // 3.模拟将最新的账户余额写入到后台
        setBalance(temp);
        
        // 实现解锁
        lock.unlock();
    }
    
    public static void main(String[] args) {
        ThreadLockTest lockTest = new ThreadLockTest(1000);
        Thread t1 = new Thread(lockTest);
        t1.start();
        Thread t2 = new Thread(lockTest);
        t2.start();
        System.out.println("主线程开始等待...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为:" + lockTest.getBalance());
    }
    
}
