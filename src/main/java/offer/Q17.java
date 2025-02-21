package offer;

/**
 * 打印从1到最大的n位数的所有数
 */
public class Q17 {
    public static void main(String[] args) {

        Print1ToMaxOfNDigits.print1ToMaxOfNDights1s(3);
    }
}

class Print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDights1s(int n) {
        if (n <= 0)
            return;
        char[] digit = new char[n];
        // 先初始化数字为0
        for (int i = 0; i < n; i++) {
            digit[i] = '0';
        }

        // 逆序 从高位到低位
        for (int i = n - 1; i >= 0; i--) {
            // 高位数字不等于9 等于9 之后
            while (digit[i] != '9') {
                int m = 0;
                digit[m]++;
                // 处理下一位数字
                while (m < n - 1 && digit[m] > '9') {
                    digit[m] = '0';
                    digit[m + 1]++;
                    m++;
                }
                printdigits(digit);
            }
        }
    }

    // 打印数字 高位0忽略 逆序打印
    private static void printdigits(char[] digit) {
        int m = digit.length - 1;
        while (digit[m] == '0')
            m--;
        for (int i = m; i >= 0; i--)
            System.out.print(digit[i]);
        System.out.println();
    }
}
