package thread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierWithActionExample {
    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, new BarrierAction());

        for (int i = 0; i < threadCount; i++) {
            new Thread(new TaskWithAction(barrier), "thread" + i).start();
        }
    }
}

class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("所有线程都到达屏障点，执行barrierAction。" + Thread.currentThread().getName());
    }
}

class TaskWithAction implements Runnable {
    private final CyclicBarrier barrier;

    TaskWithAction(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
            // 模拟任务执行
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " 到达屏障点。");
            barrier.await(); // 等待其他线程到达屏障点
            System.out.println(Thread.currentThread().getName() + " 继续执行。");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


