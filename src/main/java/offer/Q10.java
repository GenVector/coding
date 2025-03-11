package offer;

/**
 * 斐波那契数列
 */
public class Q10 {
}

class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib2(100));
    }

    // 递归实现
    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // for循环实现
    public static long fib2(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 双指针 需要记录前两个数 来计算下一个数列的值
        long n1 = 1;
        long n2 = 0;
        for (long i = 2; i <= n; i++) {
            long tem = n1;
            n1 = n1 + n2;
            n2 = tem;
        }
        return n1;
    }


}
