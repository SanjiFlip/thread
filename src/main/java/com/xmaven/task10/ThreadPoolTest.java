package com.xmaven.task10;

import com.xmaven.task15.ThreadCallableTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Ambition
 * @Description TODO 线程池
 * @Date: 2022/1/8 4:12 下午
 * @Version 1.0
 */
public class ThreadPoolTest {
    
    
    public static void main(String[] args) {
        // 1.创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 2.向线程池中布置人物
        executorService.submit(new ThreadCallableTest());
        // 3.关闭线程池
        executorService.shutdown();
    }
    
}
