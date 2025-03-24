package thread.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ThenCombine {

    public static void main(String[] args) {
        CompletableFuture<String> helloAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello 执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> worldAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("world 执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        CompletableFuture<String> result = worldAsync.thenCombineAsync(helloAsync, (hello, world) -> {
            System.out.println("result 执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return (hello + "," + world).toUpperCase();
        });
        System.out.println("获取结果 执行线程：" + Thread.currentThread().getName());
        System.out.println("两个异步任务合并结果:" + result.join());
    }

}