package com.xmaven.task10;

/**
 * @Author: Ambition
 * @Description TODO 同步模拟取款行为 用例2 同步代码块
 * @Date: 2022/1/6 5:04 下午
 * @Version 1.0
 */
public class AccountRunnableSynTest2 implements Runnable {
    
    // 用于描述账户余额
    private int balance;
    
    private Demo dm = new Demo();
    
    public AccountRunnableSynTest2() {
    }
    
    public AccountRunnableSynTest2(int balance) {
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
        // 错误做法  synchronized (new Demo())  若用new，这种相当于每个人加的都是不同的锁，采用一个引用对象，每个人用的都是同一把锁
        // 正确做法 synchronized (AccountRunnableSynTest2.class)  或者  synchronized (this)
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
        AccountRunnableSynTest2 account = new AccountRunnableSynTest2(1000);
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        t1.start();
        t2.start();
        System.out.println("主线程开始等待...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为:" + account.getBalance());
    }
}

class Demo {

}