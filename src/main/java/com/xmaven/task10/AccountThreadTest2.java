package com.xmaven.task10;

/**
 * @Author: Ambition
 * @Description TODO Thread类的同步方法 用例2
 * @Date: 2022/1/6 7:03 下午
 * @Version 1.0
 */
public class AccountThreadTest2 extends Thread {
    
    // 用于描述账户余额
    private int balance;
    
    // private Demo dm = new Demo();
    private static Demo dm = new Demo();
    
    public AccountThreadTest2() {
    }
    
    public AccountThreadTest2(int balance) {
        this.balance = balance;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    // 使用synchronized修饰方法锁不住代码
    // synchronized (this) 也锁不住对象
    @Override
    public /*synchronized*/ void run() {
//        System.out.println("子线程：" + Thread.currentThread().getName() + "-启动...");
//        synchronized (this) {
//            // 1.模拟冲后台查询账户余额的过程
//            int temp = getBalance();
//            // 2.模拟取款200元的过程
//            if (temp >= 200) {
//                System.out.println("正在出钞，请稍后...");
//                temp -= 200;
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("请取走您的钞票...");
//            } else {
//                System.out.println("余额不足，请核对您的账户余额值!");
//            }
//            // 3.模拟将最新的账户余额写入到后台
//            setBalance(temp);
//        }
        test();
    }
    
    // 正确做法
    public synchronized static void test() {
        System.out.println("子线程：" + Thread.currentThread().getName() + "-启动...");
        // 1.模拟从后台查询账户余额的过程
        int temp = 1000;
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
    }
    
    
    public static void main(String[] args) {
        AccountThreadTest2 t1 = new AccountThreadTest2(1000);
        t1.start();
        AccountThreadTest2 t2 = new AccountThreadTest2(1000);
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
