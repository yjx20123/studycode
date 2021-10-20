package com.state;

public class TestPriority {
    public static void main(String[] args) {
         //主线程的默认优先级
        System.out.println(Thread.currentThread().getName()+"------>"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);
        Thread thread6 = new Thread(myPriority);
        thread1.start();
        thread2.setPriority(1);
        thread2.start();
        thread3.setPriority(4);
        thread3.start();
        thread4.setPriority(Thread.MAX_PRIORITY);//最大优先级
        thread4.start();
        thread5.setPriority(10);
        thread5.start();
        thread6.setPriority(Thread.MIN_PRIORITY);//最小
        thread6.start();
        /*
        优先级低只是意味者获得调度的概率低,并不是优先级低就不会被调用了,这都是看CPU的调度
         */
    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"------>"+Thread.currentThread().getPriority());
    }
}