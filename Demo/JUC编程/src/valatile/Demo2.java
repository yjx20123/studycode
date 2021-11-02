package valatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {
    //volatile 不保证原子性
    private volatile  static  AtomicInteger num=new AtomicInteger();
    public static void add(){
            num.getAndIncrement();
    }

    public static void main(String[] args) {
        //理论上num结果应该为2万
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                        add();
                }
            }).start();
            while (Thread.activeCount()>2){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+" "+num);
        }
    }
}
