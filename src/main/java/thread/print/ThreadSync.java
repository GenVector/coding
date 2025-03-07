package thread.print;

public class ThreadSync {
    // 实现方式一，synchronized和wait、notify实现，不保证先执行哪一个
    public static void test1() {
        Object lock = new Object();
        boolean flag = false;
        Thread a = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 26; i++) {
                    // 直接运行
                    System.out.print(i + " ");
                    try {
                        // 先唤醒，再阻塞
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); // 结束后唤醒，防止死锁
            }
        });
        Thread b = new Thread(() -> {
            synchronized (lock) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // 直接运行
                    System.out.print(ch + " ");
                    try {
                        // 先唤醒，再阻塞
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); // 结束后唤醒，防止死锁
            }
        });
        a.start();
        b.start();
    }
    public static void main(String[] args) {
        test1();
    }
}


