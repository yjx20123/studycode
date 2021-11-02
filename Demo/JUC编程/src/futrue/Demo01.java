package futrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用 CompletableFuture
 * //异步执行
 * 成功回调
 * 失败回调
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求
        //没有返回值的异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync=>void");
//        });
//        System.out.println("11111");
//        completableFuture.get();//获得阻塞执行结果
        //有返回值的异步回调
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"sdfsaf");
            int i=10/0;
            return 1024;
        });
        completableFuture.whenComplete((t,u)->{
            System.out.println(t);//正常的返回结果
            System.out.println(u);//错误信息
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;//可以获取到错误的返回结果
            /**
             * succee Code 200
             * unsuccee 404
             */
        });
    }
}
