package thread;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class CallbackTest {
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
        Callable<Integer> callable1 = () -> {
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
            //throw new RuntimeException("run error");
            return 1;
        };
        //java 线程池
        ScheduledExecutorService jPool = Executors.newScheduledThreadPool(2);
        //Guava线程池
        ListeningScheduledExecutorService gPool = MoreExecutors.listeningDecorator(jPool);
        ListenableFuture<Integer> hFuture = gPool.schedule(callable1, 1200, TimeUnit.MILLISECONDS);
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

    private static void runnableScheduled() {

        //java 线程池
        ScheduledExecutorService jPool = Executors.newScheduledThreadPool(2);
        //Guava线程池
        ListeningScheduledExecutorService gPool = MoreExecutors.listeningDecorator(jPool);
        ListenableFuture hFuture = gPool.scheduleAtFixedRate(ExecutorServiceTest.runnable, 120L, 100L, TimeUnit.MILLISECONDS);
        FutureCallback futureCallback = new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("onSuccess" + o);
            }

            public void onFailure(Throwable throwable) {
                System.out.println("onFailure" + throwable);

            }
        };

        //Futures.addCallback(hFuture, futureCallback, gPool);

        hFuture.addListener(() -> {
            System.out.println("success");
        }, gPool);

    }

    public static void main(String[] args) {
        runnableScheduled();
    }
}
