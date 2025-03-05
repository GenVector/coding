package thread.print;

import java.util.concurrent.Semaphore;

/*
 * 交替打印
 */
public class AlternateThreads {

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                try {
                    semaphoreA.acquire(); // 申请信号量A
                    System.out.print(i + " ");
                    semaphoreB.release(); // 通知B可以运行了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (char c = 'a'; c <= 'z'; c++) {
                try {
                    semaphoreB.acquire();// 申请信号量B
                    System.out.print(c + " ");
                    semaphoreA.release();// 通知A可以运行了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
