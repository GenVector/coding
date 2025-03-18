package thread;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class CallbackTest {

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
