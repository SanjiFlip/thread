package com.xmaven.task10;

/**
 * @Author: Ambition
 * @Description TODO 非同步模拟取款行为
 * @Date: 2022/1/6 5:04 下午
 * @Version 1.0
 */
public class AccountRunnableTest implements Runnable {
    
    // 用于描述账户余额
    private int balance;
    
    public AccountRunnableTest() {
    }
    
    public AccountRunnableTest(int balance) {
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
    
    public static void main(String[] args) {
        AccountRunnableTest account = new AccountRunnableTest(1000);
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
