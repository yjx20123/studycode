package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算任务 Stream并行流
 */
public class ForkjoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    //灵界值
    private Long temp = 10000L;

    public ForkjoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if ((end - start) > temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //forkjoin
            long millde = (start - end) / 2;//中间值
            ForkjoinDemo task1 = new ForkjoinDemo(start, millde);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkjoinDemo task2 = new ForkjoinDemo(millde + 1, end);
            task2.fork();//拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }



}
