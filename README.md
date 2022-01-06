# task01 -- 线程的创建初体验

# task02 -- 线程的创建--继承Thread类

# task03 -- 线程的创建--实现Runnable接口

# task04 -- 线程的创建--匿名内部类创建线程

# task05 -- 线程编号和名称(继承Thread类 和 实现Runnable接口)

# task06 -- 线程的中断

# task07 -- 线程的优先级  优先级越高的线程不一定先执行，但是该线程获取到的时间片的机会会更多一些

# task08 -- 线程的等待

# task09 -- 守护线程

# task10 -- 线程同步机制

    ```
    基本概念：
        当多个线程同时访问同一种共享资源时，可能会造成数据的覆盖等不一致性问题，此时就需要对线程之间进行通信和协调，该机制就叫做线程的同步机制。 
        多个线程并发读写同一个临界资源时会发生线程并发安全问题。 
        异步操作:多线程并发的操作，各自独立运行。 
        同步操作:多线程串行的操作，先后执行的顺序。
        
    ```


    解决方案:
        由程序结果可知：当两个线程同时对同一个账户进行取款时，导致最终的账户余额不合理。 
        引发原因：线程一执行取款时还没来得及将取款后的余额写入后台，线程二就已经开始取款。 
        解决方案：让线程一执行完毕取款操作后，再让线程二执行即可，将线程的并发操作改为串行操作。 
        经验分享：在以后的开发尽量减少串行操作的范围，从而提高效率。
        
    实现方式
        在Java语言中使用synchronized关键字来实现同步/对象锁机制从而保证线程执行的原子性，具体 方式如下：
        使用同步代码块的方式实现部分代码的锁定，格式如下： synchronized(类类型的引用) { 编写所有需要锁定的代码； }
        使用同步方法的方式实现所有代码的锁定。 直接使用synchronized关键字来修饰整个方法即可 该方式等价于:
            synchronized(this) { 整个方法体的代码 }
    
    静态方法的锁定
        当我们对一个静态方法加锁，如:
            public synchronized static void xxx(){….}
        那么该方法锁的对象是类对象。每个类都有唯一的一个类对象。获取类对象的方式:类名.class。
        静态方法与非静态方法同时使用了synchronized后它们之间是非互斥关系的。
        原因在于：静态方法锁的是类对象而非静态方法锁的是当前方法所属对象。


# task11 -- 线程安全和死锁

    注意事项
        使用synchronized保证线程同步应当注意:
            多个需要同步的线程在访问同步块时，看到的应该是同一个锁对象引用。
            在使用同步块时应当尽量减少同步范围以提高并发的执行效率。
    
    线程安全类和不安全类
        StringBuﬀer类是线程安全的类，但StringBuilder类不是线程安全的类。 
        Vector类和 Hashtable类是线程安全的类，但ArrayList类和HashMap类不是线程安全的类。 
        Collections.synchronizedList() 和 Collections.synchronizedMap()等方法实现安全。
    
    死锁的概念
        线程一执行的代码：
        public void run(){
            synchronized(a){ //持有对象锁a，等待对象锁b
                synchronized(b){ 编写锁定的代码; }
            }
        }
        
        线程二执行的代码： 
        public void run(){
            synchronized(b){ //持有对象锁b，等待对象锁a 
                synchronized(a){ 编写锁定的代码; } 
            }
        }
        注意： 在以后的开发中尽量减少同步的资源，减少同步代码块的嵌套结构的使用！


# task12 -- 线程的创建

# task13 -- 线程的创建

# task14 -- 线程的创建

# task15 -- 线程的创建