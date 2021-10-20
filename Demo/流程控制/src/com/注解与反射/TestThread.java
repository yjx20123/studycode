package com.注解与反射;
//创建线程2：实现runnable接口，重写run方法,执行线程需要丢入runnalbe接口实现类，调用start方法
public class TestThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习"+i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        Thread thread = new Thread(testThread);
        thread.start();
        for (int i = 0; i < 999; i++) {
            System.out.println("我不学习了"+i);
        }
    }
}
