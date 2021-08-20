package offer;

public class Q16 {
    public static void main(String[] args) {
        System.out.println(Power.power(5.1,4));
    }
}

class Power {
    public static double power(double num, int exponent) {

        if (num == 0 && exponent == 0) {
            throw new RuntimeException("input error");
        }
        if (num == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int expAbs = Math.abs(exponent);
        double numAbs = Math.abs(num);
        double res = 1;
        for (int i = 0; i < expAbs; i++) {
            res *= numAbs;
        }
        if (exponent < 0) {
            res = 1 / res;
        }
        if (num < 0 && expAbs % 2 != 0) {
            res = res * -1;
        }
        return res;
    }
}
