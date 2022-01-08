package com.xmaven.task14;

/**
 * @Author: Ambition
 * @Description TODO 实现仓库类
 * @Date: 2022/1/8 3:49 下午
 * @Version 1.0
 */
public class StoreHouse {
    
    private int cnt = 0; // 用于纪律产品的数量
    
    public synchronized void produceProduct() {
        notify();
        if (cnt < 10) {
            System.out.println(
                    "线程:" + Thread.currentThread().getName() + "正在生产第" + (cnt + 1) + "个产品");
            cnt++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void consumerProduct() {
        notify();
        if (cnt > 0) {
            System.out.println(
                    "线程:" + Thread.currentThread().getName() + "正在消费第" + cnt + "个产品");
            cnt--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
