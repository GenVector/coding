package thread.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class ThenApply {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return "hello";
                }).thenApply(e -> {
                    System.out.println(Thread.currentThread().getName());
                    return e + ",";
                }).thenApply(e -> {
                    System.out.println(Thread.currentThread().getName());
                    return (e + "world").toUpperCase();
                });
        System.out.println(future.join());
    }

    @Test
    public void test() {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return "hello";
                }).thenApplyAsync(e -> {
                    System.out.println(Thread.currentThread().getName());
                    return e + ",";
                }).thenApplyAsync(e -> {
                    System.out.println(Thread.currentThread().getName());
                    return (e + "world").toUpperCase();
                });
        System.out.println(future.join());

    }
}