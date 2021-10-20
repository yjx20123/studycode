package com.state;
//测试stop
//1.建议线程正常停止--->利用次数,不建议死循环
//2.建议使用标志位--->设置一个标志位
//3.不要使用stop或者destroy等过时或者jdk不建议使用方法

public class TestStop implements Runnable {
    //设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run ...... Thread!!!" + i++);
        }

    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }

}
