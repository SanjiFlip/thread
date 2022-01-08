package com.xmaven.task14;

/**
 * @Author: Ambition
 * @Description TODO 实现生产这线程，不断生产产品
 * @Date: 2022/1/8 3:50 下午
 * @Version 1.0
 */
public class ProduceThread extends Thread {
    
    // 声明一个仓库类型的引用作为成员变量，是为了调用仓库类中的生产方法 合成复用原则
    private StoreHouse storeHouse;
    
    // 为了确保两个线程调用同一个仓库
    public ProduceThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }
    
    @Override
    public void run() {
        while (true) {
            storeHouse.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
