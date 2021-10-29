package Lock8;

import java.util.concurrent.TimeUnit;

/**
 * 增加两个静态的同步方法，只有一个对象，先打印 发短信？打电话？
 * 两个对象 先打印 发短信？打电话？
 */
public class Test3 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        Phone1 phone1 = new Phone1();
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

class Phone1 {
    //synchronized 锁的对象是方法的调用者
    //static 静态方法
    //类一加载就有了
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

    //    这里；没有锁，不是同步方法，不受锁的影响
    public static void hello() {
        System.out.println("hello");
    }
}
