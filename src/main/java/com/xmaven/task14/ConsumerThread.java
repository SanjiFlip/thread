package com.xmaven.task14;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/8 3:54 下午
 * @Version 1.0
 */
public class ConsumerThread extends Thread {
    
    // 声明一个仓库类型的引用作为成员变量，是为了调用仓库类中的生产方法 合成复用原则
    private StoreHouse storeHouse;
    
    // 为了确保两个线程调用同一个仓库
    public ConsumerThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }
    
    @Override
    public void run() {
        while (true) {
            storeHouse.consumerProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
