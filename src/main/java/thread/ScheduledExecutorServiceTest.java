package thread;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        scheduledExecutorRunnable();
    }

    private static void scheduledExecutorCallable() throws InterruptedException {
        // 创建一个支持定时、延时任务及周期性的任务执行的线程池
        // 在这之前的实现需要依靠Timer和TimerTask或者其它第三方工具来完成。但Timer有不少的缺陷
        // Runnable对象或者Callable对象。会把传入的任务封装成一个RunnableScheduledFuture对象，其实也就是ScheduledFutureTask对象
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);

        // 对于callable而言不支持多次执行。因为返回值无法确定
        ScheduledFuture<Integer> future2 = scheduledThreadPoolExecutor.schedule(ExecutorServiceTest.callable,
                5000,
                TimeUnit.MILLISECONDS);
        ScheduledFuture<Integer> future3 = scheduledThreadPoolExecutor.schedule(ExecutorServiceTest.callable,
                500,
                TimeUnit.MILLISECONDS);

        System.out.println("future2 " + future2.isDone());
        System.out.println("future3 " + future3.isDone());

    }

    private static void scheduledExecutorRunnable() throws InterruptedException {
        // 创建一个支持定时、延时任务及周期性的任务执行的线程池
        // 在这之前的实现需要依靠Timer和TimerTask或者其它第三方工具来完成。但Timer有不少的缺陷
        // Runnable对象或者Callable对象。会把传入的任务封装成一个RunnableScheduledFuture对象，其实也就是ScheduledFutureTask对象
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        // 它俩是一样的
        // 对于scheduledExecutor而言,同一个runnable任务可以重复多次提交
        ScheduledFuture future = scheduledPool.scheduleAtFixedRate(ExecutorServiceTest.runnable,
                1000,
                500,
                TimeUnit.MILLISECONDS);
        // 5000ms后开始执行任务，每隔1000ms执行一次任务
        ScheduledFuture future1 = scheduledPool.scheduleWithFixedDelay(ExecutorServiceTest.runnable,
                3000,
                1000,
                TimeUnit.MILLISECONDS);

        System.out.println("future " + future.isDone());
        System.out.println("future1 " + future1.isDone());
        Thread.sleep(10000L);
        // scheduledPool.shutdown();
        // 如何停止任务
        future.cancel(true);
        future1.cancel(true);
        System.out.println("future " + future.isDone());
        System.out.println("future1 " + future1.isDone());
        Thread.sleep(4000L);
        scheduledPool.shutdown();
        // todo 目前难以实现 每5s执行一次，一共执行10次 这样的逻辑。需要加个计数器逻辑。
    }

    private static void singleThreadScheduledExecutor() {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        // DelayedWorkQueue delayedWorkQueue = new DelayedWorkQueue();
    }

    // 对比一下和Timer原理上的区别。其实Timer就是一个单线程的线程执行器。复用一个线程来提交任务。
    // DelayedWorkQueue
}
