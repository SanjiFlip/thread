package com.xmaven.task06;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 3:46 下午
 * @Version 1.0
 */
public class ThreadSleepTest extends Thread {
    
    // 声明一个boolean变量作为循环判断的条件
    private boolean flag = true;
    
    // 子类中重写的方法不能抛出更大的异常
    @Override
    public void run() {
        // 每隔1s获取一次系统时间
        while (flag) {
            // 获取当前系统时间
            // LocalDate.now();
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(d1));
            
            // 睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        ThreadSleepTest thread = new ThreadSleepTest();
        thread.start();
        
        // 主线程执行5s后停止子线程
        System.out.println("主线程开始等待...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 停止主线程 过时了，不建议使用
        // thread.stop();
        thread.flag = false;
        System.out.println("主线程等待结束...");
    }
}
