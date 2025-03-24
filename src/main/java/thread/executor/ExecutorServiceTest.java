package thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    /**
     * 继承顺序
     * Executor -> ExecutorService -> AbstractExecutorService -> ThreadPoolExecutor
     *
     * @param args
     */
    public static void main(String[] args) {
        // 固定线程池
        Executor executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


    }
}
