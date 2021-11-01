package rw;

import sun.security.krb5.RealmException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//Read Write Lock

/**
 * 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同时占有
 * 读-读 可以共存
 * 读写  不可共存
 * 写写  不可共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        MyCacheLock myCacheLock = new MyCacheLock();
        //写入操作
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->{myCacheLock.put(temp+"",temp+"");},String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCacheLock.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
/**
 * 自定义缓存
 */
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //存，写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入ok");
    }
    //取，读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o=map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取ok");
    }
}
//加锁
class MyCacheLock{
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    //存，写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }

    }
    //取，读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o=map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取ok");
        } catch (Exception e) {

        }finally {
            readWriteLock.readLock().unlock();
        }

    }
}