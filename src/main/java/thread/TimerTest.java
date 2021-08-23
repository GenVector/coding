package thread;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTest {
    AtomicInteger integer = new AtomicInteger(0);
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            try {
                System.out.println("task1 " + Thread.currentThread().getName() + " | " + System.currentTimeMillis() + " | " + integer.incrementAndGet());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            try {
                System.out.println("task2 " + Thread.currentThread().getName() + " | " + System.currentTimeMillis() + " | " + integer.incrementAndGet());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    TimerTask task3 = new TimerTask() {
        @Override
        public void run() {
            try {
                System.out.println("task3 " + Thread.currentThread().getName() + " | " + System.currentTimeMillis() + " | " + integer.incrementAndGet());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    TimerTask task4 = new TimerTask() {
        @Override
        public void run() {
            try {
                Thread.sleep(50L);

                System.out.println("task4 " + Thread.currentThread().getName() + " | " + System.currentTimeMillis() + " | " + integer.incrementAndGet());
                if (integer.get() >= 100) {
                    //取消timer。timer一旦被cancel之后线程会被释放,无法再使用
                    timer.cancel();
                    //timer.purge(); //这个是取消timeTask。但是好像没啥用
                    //System.out.println("timer.cancel()");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    Timer timer = new Timer(true);

    public void testTimerTask() {
        timer.schedule(task, 1000L, 1000L);
    }

    public static void main(String[] args) throws InterruptedException {
        //timer 是个单线程执行器。一旦有一个线程占用了调度,别的线程会一直等待直到线程释放。有一个TimeThread继承自Thread
        //每一个timeTask 只能被调度一次。重复提交会抛出IllegalStateException: Task already scheduled or cancelled
        //可以用timer.cancel()结束后续调度。计数器的话可能需要人为实现一下
        TimerTest timerTest = new TimerTest();
        timerTest.timer.schedule(timerTest.task, 500, 100L);
        timerTest.timer.schedule(timerTest.task2, 1000L, 500L);
        timerTest.timer.scheduleAtFixedRate(timerTest.task3, 200, 1500L);
        timerTest.timer.scheduleAtFixedRate(timerTest.task4, 800, 200L);

        System.out.println(Thread.currentThread().getName() + " | " + System.currentTimeMillis());
        Thread.sleep(3000L);
        //取消任务
        timerTest.task.cancel();
        timerTest.task2.cancel();
        Thread.sleep(3000L);

    }
}
