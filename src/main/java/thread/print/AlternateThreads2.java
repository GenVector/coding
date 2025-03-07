package thread.print;


import com.google.common.collect.Lists;

import java.util.List;

public class AlternateThreads2 {

    private static final Object LOCK = new Object();
    private static String threadName = "A";

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (LOCK) {
                List<Integer> list1 = Lists.newArrayList(1, 3, 5);
                for (int i = 0; i < 3; i++) {
                    // threadName只要不是线程A，就等待
                    while (threadName != "A") {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(list1.get(i) + " ");
                    threadName = "B";
                    LOCK.notify();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (LOCK) {
                List<Integer> list2 = Lists.newArrayList(2, 4, 6);
                for (int i = 0; i < 3; i++) {
                    // threadName只要不是线程A，就等待
                    while (threadName != "B") {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(list2.get(i) + " ");
                    threadName = "A";
                    LOCK.notify();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}


