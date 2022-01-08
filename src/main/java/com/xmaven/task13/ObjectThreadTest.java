package com.xmaven.task13;

/**
 * @Author: Ambition
 * @Description TODO 线程通信
 * @Date: 2022/1/7 6:14 下午
 * @Version 1.0
 */
public class ObjectThreadTest implements Runnable {
    
    private int cnt = 1;
    
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 每当有一个线程进来后，唤醒另一个线程
                // 这里只有两个线程采用 notify(); 若是有多个线程采用 notifyAll();
                notify();
                if (cnt <= 100) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "，打印：" + cnt);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    // 当前线程打印完一个整数后，为了防止当前线程继续打印下一个元素，调用wait()
                    try {
                        wait(); // 当前线程进入阻塞状态，自动释放对象锁，必须在锁定的代码中调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
                
            }
        }
    }
    
    public static void main(String[] args) {
        ObjectThreadTest test = new ObjectThreadTest();
        Thread t1 = new Thread(test);
        t1.start();
        Thread t2 = new Thread(test);
        t2.start();
    }
    
}
