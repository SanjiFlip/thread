package com.xmaven.task03;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 12:18 上午
 * @Version 1.0
 */
public class SubRunnableRunTest {
    
    public static void main(String[] args) {
        // 1.创建自定义类型的对象，也就是实现runnable接口类的对象
        SubRunnableRun srr = new SubRunnableRun();
        // 2.使用该对象作为实参构造Thread类型的对象
        Thread thread = new Thread(srr);
        // 3.使用Thread类型的对象调用start方法
        thread.start();
        
        // 打印1-20之间的整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("------------------------main方法中i=" + i);
        }
        
    }
    
}
