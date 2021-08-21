package thread;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class ExecutorServiceTest {


    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //System.out.println("sub thread Group:" + Thread.currentThread().getThreadGroup());
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "num --" + "i");
            }
        }
    };
    private static Callable<Integer> callable = () -> {
        return 0;
    };


    private static void futureTask() throws InterruptedException, ExecutionException {
        //FutureTask;
        //Callable;
        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "num -- " + i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + "-- interrupt ");
                    return 0;
                }
                return 1;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable1);
        new Thread(futureTask).start();
        Thread.sleep(5);
        while (!futureTask.isDone()) {
            System.out.println("isCancelled  " + futureTask.isCancelled() + " | ");
            futureTask.cancel(false);//是否允许在线程运行时中断 TRUE 允许 FALSE 不允许
            System.out.println("isCancelled  " + futureTask.isCancelled() + " | ");
            //cancel执行之后置状态、但是任务可能没有被取消(没有响应中断、或者不允许线程在运行时中断)

        }
        //但是在任务cancel之后是无法获取到执行结果的 会抛出CancellationException
        System.out.println("isDone  " + futureTask.isDone());
        Integer result = futureTask.get();
        System.out.println(result);

        //这个检查是必要的
        if (!futureTask.isCancelled() && futureTask.isDone()) {
            Integer result1 = futureTask.get();
            System.out.println(result);
        }

    }

    private static void callback() {
        Callable<Integer> callable1 = () -> {
            throw new RuntimeException("run error");
        };
        //java 线程池
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        //Guava线程池
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);
        ListenableFuture<Integer> hFuture = gPool.submit(callable1);
        FutureCallback<Integer> futureCallback = new FutureCallback<Integer>() {
            public void onSuccess(Integer o) {

                System.out.println("onSuccess" + o);
            }

            public void onFailure(Throwable throwable) {
                System.out.println("onFailure" + throwable);

            }
        };

        Futures.addCallback(hFuture, futureCallback, gPool);


    }


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
        ExecutorService cachePool = Executors.newCachedThreadPool();
        //它俩是一样的(核心线程为0)
        //最大线程池无边界
        //一个线程至少占用1M资源，无限创建线程将会OOM
        //适用于处理大量、耗时少的任务
        //没事一定别用它
        ThreadPoolExecutor cachePool1 = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    private static void singleExecutor() {
        //生产一个只有一个线程的线程池，以串行执行任务。
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        //它俩是一样的
        ThreadPoolExecutor singlePool1 = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    private static void scheduledExecutor() {
        //创建一个支持定时、延时任务及周期性的任务执行的线程池
        // 在这之前的实现需要依靠Timer和TimerTask或者其它第三方工具来完成。但Timer有不少的缺陷
        //Runnable对象或者Callable对象。会把传入的任务封装成一个RunnableScheduledFuture对象，其实也就是ScheduledFutureTask对象
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        scheduledPool.scheduleAtFixedRate(runnable, 100, 10, TimeUnit.HOURS);
        scheduledPool.scheduleWithFixedDelay(runnable, 100, 10, TimeUnit.HOURS);
        //它俩是一样的
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        //对比一下和Timer原理上的区别
        //DelayedWorkQueue

    }

    private static void fixedThreadPool() {
        //固定大小的线程池
        //核心线程池大小和最大线程池大小均为5
        //目前只有它在不shut down的情况下有内存泄漏情况
        //没有持续存活时间
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        fixedThreadPool.submit(callable);
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

    private static void singleThreadScheduledExecutor() {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    private static void countDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println();
        countDownLatch();
    }

}
