package com.xmaven.task03;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 12:18 上午
 * @Version 1.0
 */
public class SubRunnableRun implements Runnable {
    
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("run方法中i=" + i);
        }
    }
}
