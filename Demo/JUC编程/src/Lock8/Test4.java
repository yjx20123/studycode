package Lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();
        //phone.sendSms();
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone1.call();
        }, "B").start();
        new Thread(() -> {
            phone.hello();
        }, "B").start();
    }
}

class Phone4 {
    //synchronized 锁的对象是方法的调用者
    //静态的同步方法，锁的是CLass模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

    //普通的同步方法 锁的调用者
    public synchronized void hello() {
        System.out.println("hello");
    }
}

