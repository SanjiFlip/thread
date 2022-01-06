package com.xmaven.task09;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/6 4:48 下午
 * @Version 1.0
 */
public class ThreadDaemonTest extends Thread {
    
    @Override
    public void run() {
        System.out.println(isDaemon() ? "该线程是守护线程！" : "该线程不是守护线程"); // 默认不是守护线程
        for (int i = 0; i < 50; i++) {
            System.out.println("子线程中i = " + i);
        }
    }
    
    public static void main(String[] args) {
        ThreadDaemonTest daemonTest = new ThreadDaemonTest();
        // 设置成守护线程 必须在线程启动之前设置子线程为守护线程
        // 子线程为非守护线程就是主线程执行完毕时，子线程未执行完，该子线程任会继续执行，直到所有数据执行完毕
        // 子线程为守护线程时，主线程执行完毕，子线程也随之结束
        daemonTest.setDaemon(true);
        daemonTest.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("---------主线程中i = " + i);
        }
        System.out.println("主线程执行完毕！");
    }
}
