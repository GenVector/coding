package coding2;

/*
 *剪绳子
 */
public class CutRope {
    public static int maxProductAfterCutting(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3; // 这个地方确实和上面的不一样 这里可以剪一段
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                products[i] = Math.max(products[i], products[j] * products[i - j]);
            }
        }
        return products[n];
    }

    public static void main(String[] args) {
        int n = 4; // 绳子长度
        int result = maxProductAfterCutting(n);
        System.out.println("最大乘积: " + result);

        // 长度为N的绳子 剪成 1 *(N-1) 一定不如 2*(N-2) 大 所以内层从2开始循环
    }
}