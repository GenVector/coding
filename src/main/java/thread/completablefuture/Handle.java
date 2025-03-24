package thread.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class Handle {
    /*
     * handle 是执行任务完成时对结果的处理， handle 方法和 thenApply 方法处理方式大致一样，
     * 不同的是 handle 是在任务完成后再执行且Handle可以根据可以根据任务是否有异常来进行做相应的后续处理操作。
     * 也就是比thenApply 添加了一个异常参数
     */
    @Test
    public void testHandle() {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前supplyAsync 执行线程：" + Thread.currentThread().getName());
            // 模拟异常
            int a = 1 / 0;
            return "hello";
        }).handle((x, t) -> {
            System.out.println("当前handle 执行线程：" + Thread.currentThread().getName());
            if (t != null) {
                // 出现异常 打印异常信息 或者doSomething
                System.out.println("发现上一个异步任务出异常了" + t.getMessage());
            } else {
                // 未出异常 doSomething
                return x;
            }
            // 设置默认结果
            return "error";
        });
        System.out.println(future.join());
    }
}
