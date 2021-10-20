package com.注解与反射;
//多个线程同时操作同一个对象
//买火车票的例子
//发现问题，多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements Runnable{
    //票数
    private int ticketNums=10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        Thread thread = new Thread(testThread4,"小明");
        Thread thread1 = new Thread(testThread4,"小红");
        Thread thread2 = new Thread(testThread4,"小兰");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
