package offer;

public class Q14 {
    public static void main(String[] args) {
        System.out.println(CuttingRope.maxProductAfterCutting(11));
        System.out.println(CuttingRope.maxProductAfterCutting2(11));

    }

    /*
     * 剪绳子 动态规划算法
     * 给定一根长度为 n 的绳子，将其剪成若干段，使得每段长度的乘积最大。
     */
    static class CuttingRope {

        // 动态规划算法
        public static long maxProductAfterCutting(int length) {
            if (length <= 1) {
                return 0;
            }
            if (length == 2) {
                return 1;
            }
            if (length == 3) {
                return 2;
            }
            long[] maxLength = new long[length + 1];
            maxLength[1] = 1;
            maxLength[2] = 2;
            maxLength[3] = 3;
            for (int i = 4; i <= length; i++) {
                maxLength[i] = 0;
                for (int j = 2; j < i; j++) {
                    maxLength[i] = Math.max(maxLength[j] * maxLength[i - j], maxLength[i]);
                }
            }
            return maxLength[length];
        }

        // 贪心算法
        public static long maxProductAfterCutting2(int length) {
            if (length <= 1) {
                return 0;
            }
            if (length == 2) {
                return 1;
            }
            if (length == 3) {
                return 2;
            }
            int length3 = length / 3;
            int remainder = length % 3;
            if (remainder == 1) {
                length3--;
            }
            int length2 = (length - length3 * 3) / 2;
            return (long) (Math.pow(3, length3) * Math.pow(2, length2));
        }
    }
}


