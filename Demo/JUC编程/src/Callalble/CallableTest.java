package Callalble;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask<>(myThread);
        new Thread(futureTask,"A").start();
        String s = (String) futureTask.get();
        System.out.println(s);
    }

}
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "123";
    }
}
