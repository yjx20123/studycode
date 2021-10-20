package com.syn;
//bu安全的买票
//两个人去银行取钱，账户

public class UnsageBuyTicket {
    public static void main(String[] args) {
        BuyTickert buyTickert = new BuyTickert();
        new Thread(buyTickert, "苦逼的我").start();
        new Thread(buyTickert, "牛逼的我").start();
        new Thread(buyTickert, "没钱的我").start();
    }
}

class BuyTickert implements Runnable {
    //票
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        //买票

        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//synchronized同步方法

    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}
