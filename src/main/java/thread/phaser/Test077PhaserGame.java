package thread.phaser;

import java.util.concurrent.Phaser;

public class Test077PhaserGame {


    private static final int PLAYER_COUNT = 3;

    public static void main(String[] args) {
        Phaser phaser = new Phaser(PLAYER_COUNT) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                // 三次没有杀死，Boss 回血 30%
                GameBoss.Instance.enhancement(phase);
                return false; // 返回 true 会终止 phaser
            }
        };


        for (int i = 0; i < PLAYER_COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    double blood = 100; // 自己的血量
                    String threadName = Thread.currentThread().getName();
                    double attckVal = 0;

                    for (int j = 1; ; j++) {
                        Thread.sleep((int) (Math.random() * 1000 % 1000)); // 模拟玩家操作延时
                        attckVal = Math.random() * 100 % 20;
                        if (GameBoss.Instance.attack(threadName, attckVal, j)) {
                            return;
                        }
                        blood -= Math.random() * 10 % 10;
                        if (blood <= 0) {
                            // BOSS 没死，自己死了
                            System.out.println(threadName + " GG");
                            break;
                        }

                        if (j % 3 == 0) {
                            // 每攻击3次进入屏障，等待回血（你也可以刷怪）
                            phaser.arriveAndAwaitAdvance();
                        }
                    }

                    System.out.println(threadName + " 离开");
                    phaser.arriveAndDeregister();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("玩家" + (i + 1) + " ");
            thread.start();
        }
    }


    public static class GameBoss {
        public static GameBoss Instance = new GameBoss();

        private GameBoss() {

        }

        private double bossValue = 100;

        public void enhancement(int phase) {
            bossValue = Math.max(100, bossValue * 1.3);
//            bossValue = bossValue * 1.3;
//            if (bossValue > 100) {
//                bossValue = 100;
//            }
            System.out.println("第" + phase + "阶段回血，Boss 回血 30%");
            System.out.println("当前血量：" + bossValue);
        }

        public synchronized boolean attack(String player, double val, int times) {
            if (bossValue < 0) {
                return true;
            }

            bossValue -= val;
            System.out.println(player + "第" + times + "次发动攻击，伤害=" + val);

            if (bossValue < 0) {
                System.out.println(player + "击杀");
                return true;
            }

            return false;
        }
    }
}


