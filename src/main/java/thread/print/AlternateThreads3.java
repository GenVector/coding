package thread.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateThreads3 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile String threadName = "A";

    /**
     * 目标：交替执行的基础上，必须先执行A，再执行B
     * 方案：lock_condition机制 + Thread标志位
     * 实现思路：和我wait_notiy实现的基本一致，也是，只不过wait变成了await，notify变成了signal
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    while (threadName != "A") {
                        condition.await();
                    }
                    System.out.print(i + " ");
                    threadName = "B";
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                lock.lock();
                for (char c = 'a'; c <= 'z'; c++) {
                    while (threadName != "B") {
                        condition.await();
                    }
                    System.out.print(c + " ");
                    threadName = "A";
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}



