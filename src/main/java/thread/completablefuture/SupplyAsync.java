package thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SupplyAsync {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            // 异步方法内当前执行线程为:ForkJoinPool.commonPool-worker-1
            System.out.println(" 1 异步方法内当前执行线程为:" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
                System.out.println(" 1 异步方法内当前执行线程为:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" 2 异步方法内当前执行线程为:" + Thread.currentThread().getName());
            // 模拟返回值
            return "hello,world";
        });

        System.out.println("异步线程执行=====" + supplyAsync.get(200, TimeUnit.MILLISECONDS));
        // 获取异步线程执行结果
//        System.out.println(supplyAsync.join());
        if (supplyAsync.isDone()) {
            System.out.println("异步线程执行完毕" + supplyAsync.get());
        }

        System.out.println("主线程执行完毕");
    }
}