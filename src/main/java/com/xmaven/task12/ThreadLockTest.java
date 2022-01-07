package com.xmaven.task12;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/7 5:42 下午
 * @Version 1.0
 */
public class ThreadLockTest implements Runnable {
    
    // 用于描述账户余额
    private int balance;
    
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
    }
}
