package offer;

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
        for (int i = 0; i < n; i++)
            digit[i] = '0';
        for (int i = n - 1; i >= 0; i--) {
            while (digit[i] != '9') {
                int m = 0;
                digit[m]++;
                while (m < n - 1 && digit[m] > '9') {
                    digit[m] = '0';
                    digit[m + 1]++;
                    m++;
                }
                printdigits(digit);
            }
        }
    }

    private static void printdigits(char[] digit) {
        int m = digit.length - 1;
        while (digit[m] == '0')
            m--;
        for (int i = m; i >= 0; i--)
            System.out.print(digit[i]);
        System.out.println();
    }
}
