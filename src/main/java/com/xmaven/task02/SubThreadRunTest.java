package com.xmaven.task02;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/5 10:49 下午
 * @Version 1.0
 */
public class SubThreadRunTest {
    
    public static void main(String[] args) {
        // 1.声明Thread类型的引用指向子类类型的对象 多态的形式
        Thread t1 = new SubThreadRun();
        // 2.调用run方法进行测试，这里的run调用的是子类SubThreadRun的run方法   正确的应该调用star方法
        // 这种方法本质相当于就是对普通成员方法的调用 run方法调用完后才能后面的方法才能执行
        // t1.run();
        
        // 用于启动线程,Java虚拟机会自动调用该类线程类中的run方法
        // 相当于又启动了一个线程，加上执行main方法的线程是两个线程
        t1.start();
        
        // 打印1-20之间的整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("------------------------main方法中i=" + i);
        }
    }
    
}
