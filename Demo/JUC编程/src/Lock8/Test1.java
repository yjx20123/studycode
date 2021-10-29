package Lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1、标准情况下，两个线程先打印 发短信还是打电话
 */
public class Test1{
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        //phone.sendSms();
        new Thread(()->{
            phone.sendSms();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone1.call();
        },"B").start();new Thread(()->{
            phone.hello();
        },"B").start();
    }
}
class Phone{
    //synchronized 锁的对象是方法的调用者
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
//    这里；没有锁，不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}
