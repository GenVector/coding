package lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static ReentrantLock reentrantLock = new ReentrantLock(false);
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public static Runnable runnable = () -> {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " | " + atomicInteger.getAndIncrement());
        Condition condition = reentrantLock.newCondition();
        try {
            System.out.println(Thread.currentThread().getName() + " | " + "condition.await()");
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    };


    public static void testReentrantLock() {
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(runnable, "thread:" + i);
            thread1.start();
        }
    }

    public static void testReadWriteLock() {
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        Runnable runnable1 = () -> {
            int state = atomicInteger.get();
            if (state == 0) {
                writeLock.lock();
            } else {
                readLock.lock();
            }
            System.out.println(Thread.currentThread().getName() + " | " + atomicInteger.getAndIncrement());

            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (state == 0) {
                writeLock.unlock();
            } else {
                readLock.unlock();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(runnable1, "thread:" + i);
            thread1.start();
        }
    }

    public static void testCondition() {
        Runnable runnable1 = () -> {
            reentrantLock.lock();
            atomicInteger.getAndIncrement();
            //System.out.println(Thread.currentThread().getName() + " | " + atomicInteger.getAndIncrement());
            Condition condition = reentrantLock.newCondition();
            try {
                if (atomicInteger.get() / 2 == 0) {
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + " | " + "condition.await()");
                } else {
                    condition.signal();
                    System.out.println(Thread.currentThread().getName() + " | " + "condition.signal()");

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        };

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(runnable1, "thread:" + i);
            thread1.start();
        }
    }

    public static void main(String[] args) {
        testCondition();
    }
}
