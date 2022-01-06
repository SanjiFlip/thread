package com.xmaven.task05;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 3:27 下午
 * @Version 1.0
 */
public class ThreadIdNameTest extends Thread {
    
    public ThreadIdNameTest(String name) {
        super(name);    //表示调用父类的构造方法
    }
    
    @Override
    public void run() {
        System.out.println("子线程的ID为：" + getId() + "——————子线程的Name为：" + getName());
        setName("zhangfei");
        System.out.println("修改后，子线程的ID为：" + getId() + "——————子线程的Name为：" + getName());
    }
    
    public static void main(String[] args) {
        Thread t1 = new ThreadIdNameTest("guanyu");
        t1.start();
        
        // 获取当前正在执行线程的引用，当前正在执行的线程是主线程
        Thread main = Thread.currentThread();
        System.out.println("主线程的Id为：" + main.getId() + "主线程的name为：" + main.getName());
    }
    
    
}
