package com.xmaven.task02;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/5 10:47 下午
 * @Version 1.0
 */
public class SubThreadRun extends Thread {
    
    
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("run方法中i=" + i);
        }
    }
}
