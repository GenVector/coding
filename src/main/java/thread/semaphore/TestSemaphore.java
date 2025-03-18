package thread.semaphore;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {

    private static Semaphore SEMAPHORE = new Semaphore(1);
    //todo 中断之后许可可能会加多====================
    public static void testSemaphore() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    SEMAPHORE.acquire();
                    System.out.println("获取许可=========>" + Thread.currentThread().getName());

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    System.out.println("释放许可==========>" + Thread.currentThread().getName());
                    SEMAPHORE.release();


                }
            },"t" + i).start();
        }
    }


    public static void main(String[] args) {
        testSemaphore();
    }

}
