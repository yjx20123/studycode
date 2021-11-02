package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
    }
    //普通程序员
    public static void test1(){
        Long sum=0L;
        long start = System.currentTimeMillis();
        for (Long i=1L;i<=10_0000_0000;i++){
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("普通程序员求和sum="+sum+"时间="+(end-start));
    }
    //会使用ForkJoin
    public static  void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkjoinDemo task = new ForkjoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();

        long end= System.currentTimeMillis();
        System.out.println("Forkjoinsum求和="+sum+"时间="+(end-start));
    }
    //使用stream并行流
    public static void test3(){
        long start=System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("Stream并行流求和sum求和="+sum+"时间="+(end-start));
    }
}
