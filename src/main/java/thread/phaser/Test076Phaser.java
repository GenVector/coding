package thread.phaser;


import java.util.concurrent.Phaser;

public class Test076Phaser {

    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {

        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("=====第" + phase + "阶段完成=====");
                return false; // 返回 true 会终止 phaser
            }
        };

        for (int i = 1; i <= NUM_THREADS; i++) {
            phaser.register();// 注册线程
            Thread thread = new Thread(() -> {

                String threadName = Thread.currentThread().getName();
                // 使用 for 循环来模拟3个阶段
                for (int phase = 0; phase < 5; phase++) {
                    // 这是第 phase 阶段
                    System.out.println(threadName + " 执行第" + phase + "阶段任务...");
                    System.out.println(threadName + " 第" + phase + "阶段完成，到达屏障点");
                    phaser.arriveAndAwaitAdvance(); // 等待其他线程到达屏障点
                }

                System.out.println(threadName + " 完成所有阶段");
                System.out.println(threadName + " 解除线程的注册");
                phaser.arriveAndDeregister();// 任务完成解除线程注册
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}


