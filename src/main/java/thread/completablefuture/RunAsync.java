package thread.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class RunAsync {
    public static void main(String[] args) {
        //当前调用者线程为:main
        System.out.println("当前调用者线程为:" + Thread.currentThread().getName());
        CompletableFuture.runAsync(() -> {
            // 异步方法内当前执行线程为:ForkJoinPool.commonPool-worker-1
            System.out.println("异步方法内当前执行线程为:" + Thread.currentThread().getName());
            System.out.println(111);
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> {
            // 异步方法内当前执行线程为:ForkJoinPool.commonPool-worker-1
            System.out.println("异步方法内当前执行线程为:" + Thread.currentThread().getName());
            System.out.println(2222);
        }, executor);


        ThreadFactory factory = (v) -> {
            Thread t = new Thread(v);
            t.setDaemon(false);
            t.setName("my-thread" + new Random().nextInt(100));
            return t;
        };

        executor.shutdown();


    }


}
