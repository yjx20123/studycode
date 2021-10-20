package com.state.线程休眠;

public class sleep implements Runnable{
    private int tickNums=10;

    @Override
    public void run() {
        while (true){
            if(tickNums<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+tickNums--);
        }
    }

    public static void main(String[] args) {
        sleep sleep1 = new sleep();
        new Thread(sleep1,"小米").start();
        new Thread(sleep1,"华为").start();
        new Thread(sleep1,"三星").start();
        new Thread(sleep1,"魅族").start();
    }
}
