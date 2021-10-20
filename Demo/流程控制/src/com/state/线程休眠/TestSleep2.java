package com.state.线程休眠;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {
    public static void main(String[] args) {
        int[] shu={1,2,3,4};
       int[] shu1=new int[]{1,32,5,4,3};
        //打印当前系统时间
        Date starttime = new Date(System.currentTimeMillis());//获取系统当前时间
        System.out.println("我是当前时间" + starttime);
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(starttime));
                starttime = new Date(System.currentTimeMillis());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
//    public void tenDown() throws InterruptedException {
//        int num=10;
//        while (true){
//            Thread.sleep(1000);
//            System.out.println(num--);
//            if(num<=0){
//                break;
//            }
//        }
//    }
}
