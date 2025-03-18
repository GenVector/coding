package thread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiStageTaskExample {
    public static void main(String[] args) {
        int threadCount = 4;
        int stageCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, new BarrierAction());

        // 四个线程 三个阶段 循环使用
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Worker(barrier, stageCount)).start();
        }
    }
}

class Worker implements Runnable {
    private final CyclicBarrier barrier;
    private final int stageCount;

    Worker(CyclicBarrier barrier, int stageCount) {
        this.barrier = barrier;
        this.stageCount = stageCount;
    }

    @Override
    public void run() {
        try {
            for (int stage = 1; stage <= stageCount; stage++) {
                // 模拟每个阶段的任务
                System.out.println(Thread.currentThread().getName() + " 正在执行第 " + stage + " 阶段任务...");
                Thread.sleep((long) (Math.random() * 1000)); // 模拟任务执行时间

                // 等待其他线程到达屏障点
                System.out.println(Thread.currentThread().getName() + " 到达第 " + stage + " 阶段屏障点。");
                barrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}



