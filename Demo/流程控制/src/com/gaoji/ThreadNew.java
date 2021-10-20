package com.gaoji;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//回顾总结线程的创建
public class ThreadNew {
    public static void main(String[] args) {
        new first().start();
        new Thread(new second()).start();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(new third());
        new Thread(futureTask).start();
    try {
        Integer integer=futureTask.get();
        System.out.println(integer);
    } catch (ExecutionException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
//继承thread类
class first extends Thread{
    @Override
    public void run() {
        System.out.println("距离产生美");
    }
}
class second implements Runnable{

    @Override
    public void run() {
        System.out.println("这是runnble");
    }
}
class third implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("这是callable方法");
        return 100;
    }
}
