package thread;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class ExecutorServiceTest {


    static Runnable runnable = () -> {
        //System.out.println("sub thread Group:" + Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getName() + "runnable --");
        //throw new RuntimeException("error");
    };

    static Callable<Integer> callable = () -> {
        System.out.println(Thread.currentThread().getName() + "callable --");

        return 0;
    };


    //自定义线程池
    //参数说明
    //corePoolSize:核心线程池数量int
    //maximumPoolSize:最大线程池大小
    //keepAliveTime:线程最大空闲时间
    //TimeUnit:时间单位
    //ThreadFactory:线程工厂
    //workQueue:线程等待列队
    //handle:拒绝策略
    private static ThreadPoolExecutor customExecutor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(20));

    private static void customExecutor() throws InterruptedException, ExecutionException {
        Future<Integer> res = customExecutor.submit(callable);
        System.out.println(res.get());
        res = customExecutor.submit(callable);
        System.out.println(res.get());
        res = customExecutor.submit(callable);
        System.out.println(res.get());
    }

    private static void cacheExecutor() {
        //带缓存的线程池
        //ExecutorService cachePool = Executors.newCachedThreadPool();
        //它俩是一样的(核心线程为0)
        //最大线程池无边界
        //一个线程至少占用1M资源，无限创建线程将会OOM
        //适用于处理大量、耗时少的任务
        //没事一定别用它
        ThreadPoolExecutor cachePool1 = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), r -> {
            Thread thread = new Thread();
            thread.setDaemon(true);
            return thread;
        });
        cachePool1.submit(callable);

    }

    private static void singleExecutor() {
        //生产一个只有一个线程的线程池，以串行执行任务。
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        //它俩是一样的
        ThreadPoolExecutor singlePool1 = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }


    private static void fixedThreadPool() {
        //固定大小的线程池
        //核心线程池大小和最大线程池大小均为5
        //目前只有它在不shut down的情况下可能有内存泄漏情况
        //没有持续存活时间
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        fixedThreadPool.submit(callable);
        //
        //fixedThreadPool.shutdown();
    }

    private static void workStealingPool() {
        //任务窃取线程池
        //注意,它和上面的几个都不太一样
        //ForkJoinPool 主要用于实现“分而治之”的算法，特别是分治之后递归调用的函数
        //ForkJoinPool 最适合的是计算密集型的任务，如果存在 I/O，线程间同步，sleep() 等会造成线程长时间阻塞的情况时，最好配合使用 ManagedBlocker。
        ExecutorService workStealingPool = Executors.newWorkStealingPool(5);

        //参数 parallel并行数
        //workerThreadFactory
        //是否启用异步asyncMode
        ForkJoinPool forkJoinPool = new ForkJoinPool(5, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);

        workStealingPool.submit(callable);
    }


    private static void countDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        workStealingPool();
        Thread.sleep(2000L);
        //System.gc();

    }

}
