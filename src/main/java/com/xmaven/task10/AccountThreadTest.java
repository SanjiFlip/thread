package com.xmaven.task10;

/**
 * @Author: Ambition
 * @Description TODO Thread类的同步代码块 用例1
 * @Date: 2022/1/6 7:03 下午
 * @Version 1.0
 */
public class AccountThreadTest extends Thread {
    
    // 用于描述账户余额
    private int balance;
    
    // private Demo dm = new Demo();
    private static Demo dm = new Demo();
    
    public AccountThreadTest() {
    }
    
    public AccountThreadTest(int balance) {
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
        System.out.println("子线程：" + Thread.currentThread().getName() + "-启动...");
        // 这个时候 使用dm就锁不住了，应为每次使用的都是new AccountThreadTest 里面的dm都是新开辟的对象，属于不同的锁
        /**
         * 正确的三种方法
         *  1.静态引用对象
         *  2.synchronized(AccountThreadTest.class)
         */
        synchronized (dm) {
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
    
    public static void main(String[] args) {
        AccountThreadTest t1 = new AccountThreadTest(1000);
        t1.start();
        AccountThreadTest t2 = new AccountThreadTest(1000);
        t2.start();
        System.out.println("主线程开始等待...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为:" + t1.getBalance());
        
    }
}
