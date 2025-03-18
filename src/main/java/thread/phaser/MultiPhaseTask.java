package thread.phaser;

import java.util.concurrent.Phaser;

public class MultiPhaseTask {

    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {

        // 注册线程可以通过构造函数的参数指定，也可以通过 phaser.register(); 方法注册线程。
        Phaser phaser = new Phaser(NUM_THREADS) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("第" + phase + "阶段完成");
                return false; // 返回 true 会终止 phaser
            }
        };

        for (int i = 0; i < NUM_THREADS; i++) {
            // phaser.register(); // 如果上面造函数的参数没有指定，则启用这句话来注册线程
            Thread thread = new Thread(() -> {

                // 使用 for 循环来模拟3个阶段
                for (int phase = 1; phase <= 3; phase++) {
                    // 这是第 phase 阶段
                    System.out.println("执行第 phase 阶段 任务..." + Thread.currentThread().getName());
                    phaser.arriveAndAwaitAdvance(); // 等待其他线程到达屏障点
                }

                System.out.println("完成所有阶段" + Thread.currentThread().getName());
                // 解除线程的注册
                phaser.arriveAndDeregister();
            });
            thread.setName("Thread-" + i);
            thread.start();
        }
    }
}

