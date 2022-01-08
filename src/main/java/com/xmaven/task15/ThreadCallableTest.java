package com.xmaven.task15;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/8 4:05 下午
 * @Version 1.0
 */
public class ThreadCallableTest implements Callable {
    
    @Override
    public Object call() throws Exception {
        // 计算1-10000之间的累加和
        int sum = 0;
        for (int i = 0; i <= 10000; i++) {
            sum += i;
        }
        System.out.println("计算的累加和：" + sum);
        return sum;
    }
    
    public static void main(String[] args) {
        ThreadCallableTest callableTest = new ThreadCallableTest();
        FutureTask task = new FutureTask<>(callableTest);
        Thread thread = new Thread(task);
        thread.start();
        Object obj = null;
        try {
            obj = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程处理返回结果是：" + obj);
    }
}
