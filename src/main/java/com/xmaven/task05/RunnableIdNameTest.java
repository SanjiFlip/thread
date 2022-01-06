package com.xmaven.task05;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 3:38 下午
 * @Version 1.0
 */
public class RunnableIdNameTest implements Runnable {
    
    @Override
    public void run() {
        // 获取当前正在执行线程的引用，也就是子线程的引用
        Thread currentThread = Thread.currentThread();
        System.out.println(
                "子线程的id:" + currentThread.getId() + "子线程的name:" + currentThread.getName());
        currentThread.setName("zhangfei");
        System.out.println(
                "修改后，子线程的id:" + currentThread.getId() + "子线程的name:" + currentThread.getName());
        
    }
    
    public static void main(String[] args) {
        RunnableIdNameTest runnable = new RunnableIdNameTest();
        // Thread thread = new Thread(runnable);
        Thread thread = new Thread(runnable, "guangyu");
        thread.start();
        
        // 获取当前正在执行线程的引用，当前正在执行的线程是主线程
        Thread main = Thread.currentThread();
        System.out.println("主线程的Id为：" + main.getId() + "主线程的name为：" + main.getName());
    }
}
