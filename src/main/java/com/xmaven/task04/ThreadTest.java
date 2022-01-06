package com.xmaven.task04;

/**
 * @Author: Ambition
 * @Description TODO 匿名内部类创建线程
 * @Date: 2022/1/6 12:27 上午
 * @Version 1.0
 */
public class ThreadTest {
    
    public static void main(String[] args) {
        // 匿名内部类的语法格式: 父类/接口类型 引用变量名 = new 父类/接口类型(){ 方法的重写 }
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("张三说在吗？");
            }
        };
        t1.start();
        
        // 优化一句话
        new Thread() {
            @Override
            public void run() {
                System.out.println("张三说在吗？");
            }
        }.start();
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("李四说我不在!");
            }
        };
        Thread t2 = new Thread(runnable);
        t2.start();
        
        // 优化一句话
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("李四说我不在!");
            }
        }).start();
        
        // java8使用lambda表达式 (形参列表)->{方法体;}
        Runnable ra = () -> {
            System.out.println("nm炸了！");
        };
        new Thread(ra).start();
        
        new Thread(() -> {
            System.out.println("nb炸了！");
        }).start();
    }
    
}
