package thread;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        scheduledExecutor();
    }

    private static void scheduledExecutor() throws InterruptedException {
        //创建一个支持定时、延时任务及周期性的任务执行的线程池
        // 在这之前的实现需要依靠Timer和TimerTask或者其它第三方工具来完成。但Timer有不少的缺陷
        //Runnable对象或者Callable对象。会把传入的任务封装成一个RunnableScheduledFuture对象，其实也就是ScheduledFutureTask对象
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        //对于scheduledExecutor而言,同一个runnable任务可以重复多次提交
        ScheduledFuture future = scheduledPool.scheduleAtFixedRate(ExecutorServiceTest.runnable, 1000, 500, TimeUnit.MILLISECONDS);
        ScheduledFuture future1 = scheduledPool.scheduleWithFixedDelay(ExecutorServiceTest.runnable, 500, 1000, TimeUnit.MILLISECONDS);
        //对于callable而言不支持多次执行。因为返回值无法确定
        ScheduledFuture<Integer> future2 = scheduledPool.schedule(ExecutorServiceTest.callable, 100, TimeUnit.MILLISECONDS);
        //它俩是一样的
        //ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        Thread.sleep(5000L);
        //scheduledPool.shutdown();
        //如何停止任务
        future.cancel(true);
        future1.cancel(true);
    }

    private static void singleThreadScheduledExecutor() {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        //DelayedWorkQueue delayedWorkQueue = new DelayedWorkQueue();
    }

    //对比一下和Timer原理上的区别。其实Timer就是一个单线程的线程执行器。复用一个线程来提交任务。
    //DelayedWorkQueue
}
