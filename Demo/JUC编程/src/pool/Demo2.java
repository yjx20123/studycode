package pool;

import java.util.concurrent.*;
//new ThreadPoolExecutor.AbortPolicy()//人满了，还有人进来，不处理这个人的，抛出异常
//new ThreadPoolExecutor.CallerRunsPolicy());//哪来的去哪里
//new ThreadPoolExecutor.DiscardPolicy());//队列满了，丢掉任务，不会抛出异常
//new ThreadPoolExecutor.DiscardOldestPolicy());//队列满了，尝试去和最早的竞争，也不会抛出异常
public class Demo2 {
    public static void main(String[] args) {
        //自定义线程池！工作ThreadPoolExecutor
        /**
         * 最大线程到底该如何定义
         * 1、cpu密集型 几核，就是几，可以保持cpu的效率最高
         * 2、io 密集型 判断你程序中十分耗IO的线程
         * 程序 15个大型任务，IO十分占用资源
         */

        //获取cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());//队列满了，尝试去和最早的竞争，也不会抛出异常

        try {
            //
            for (int i = 0; i < 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"----OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
