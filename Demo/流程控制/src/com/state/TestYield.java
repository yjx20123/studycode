package com.state;

//yield 线程礼让
//礼让不一定成功,看cpu心情
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a线程").start();
        new Thread(myYield,"b线程").start();
    }
}
class MyYield implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}