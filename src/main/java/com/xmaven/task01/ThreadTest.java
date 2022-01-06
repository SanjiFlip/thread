package com.xmaven.task01;

/**
 * @Author: Ambition
 * @Description TODO
 * @Date: 2022/1/5 7:46 下午
 * @Version 1.0
 */
public class ThreadTest {
    
    public static void main(String[] args) {
        // 1.使用无参方式构造Thread方法
        // 由源码可知 ：Thread类中的成员变量target为null
        Thread thread1 = new Thread();
        // 2.调用run方法进行测试
        // 由源码可知：由于成员变量target为null，因此if (target != null)不成立，跳过{}中的代码不执行
        thread1.run();
        // 随意打印一句话
        System.out.println("测试是否执行到了这句话！");
    }
    
}
