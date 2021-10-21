package com.注解与反射;

//模拟龟兔赛跑
public class 龟兔赛跑 implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    //判断是否完赛
    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            return true;
        }
        {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        龟兔赛跑 race = new 龟兔赛跑();
        Thread thread = new Thread(race,"兔子");
        Thread thread1 = new Thread(race,"乌龟");
        thread.start();
        thread1.start();

    }
}
