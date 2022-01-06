package com.xmaven.task10;

/**
 * @Author: Ambition
 * @Description TODO Thread类的同步方法 用例3
 * @Date: 2022/1/6 7:03 下午
 * @Version 1.0
 */
public class AccountThreadTest3 extends Thread {
    
    // 用于描述账户余额
    private int balance;
    
    // private Demo dm = new Demo();
    private static Demo dm = new Demo();
    
    public AccountThreadTest3() {
    }
    
    public AccountThreadTest3(int balance) {
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
        /**
         *  synchronized(AccountThreadTest.class)
         *  该类型对应的Class对象，由于类型是固定的，因此Class也是唯一的，因此可以实现同步
         */
        synchronized (AccountThreadTest3.class) {
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
        }
    }
    
    public static void main(String[] args) {
        AccountThreadTest3 t1 = new AccountThreadTest3(1000);
        t1.start();
        AccountThreadTest3 t2 = new AccountThreadTest3(1000);
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
