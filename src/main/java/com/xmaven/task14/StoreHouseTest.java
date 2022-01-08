package com.xmaven.task14;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/8 3:56 下午
 * @Version 1.0
 */
public class StoreHouseTest {
    
    public static void main(String[] args) {
        StoreHouse storeHouse = new StoreHouse();
        ProduceThread t1 = new ProduceThread(storeHouse);
        ConsumerThread t2 = new ConsumerThread(storeHouse);
        t1.start();
        t2.start();
    }
}
