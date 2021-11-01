package bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.test3();
    }
    //抛出异常
    public void test1(){
        //队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
//        Exception in thread "main" java.lang.IllegalStateException: Queue full 抛出异常
//        System.out.println(arrayBlockingQueue.add("d"));
        System.out.printf("", arrayBlockingQueue.remove());
        System.out.printf("", arrayBlockingQueue.remove());
        System.out.printf("", arrayBlockingQueue.remove());
//        Exception in thread "main" java.util.NoSuchElementException
//        System.out.printf("", arrayBlockingQueue.remove());
    }
    //有返回值，无异常
    public void test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.printf("", arrayBlockingQueue.offer("a"));
        System.out.printf("", arrayBlockingQueue.offer("b"));
        System.out.printf("", arrayBlockingQueue.offer("c"));
        System.out.printf("", arrayBlockingQueue.offer("c"));
        System.out.printf("", arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

    }
    //等待，阻塞(一直阻塞)
    public void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        //一直阻塞
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
//        arrayBlockingQueue.put("d"); 队列无位置，一直阻塞
//        arrayBlockingQueue.put("e");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
//        System.out.println(arrayBlockingQueue.take());//没有该元素，会阻塞等待


    }
    //等待，阻塞（等待，超时）
    public void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("ab");
        arrayBlockingQueue.offer("ac");
        arrayBlockingQueue.offer("ad",2, TimeUnit.SECONDS);
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll(2,TimeUnit.SECONDS);
    }
}
