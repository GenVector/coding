package offer;

public class Q67 {
}

//题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
//能使用atoi或者其他类似的库函数。

class StringToInt {
    public static int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("input str error");
        }
        int symbol = 1;
        long num = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if ((c <= '9' && c >= '0') || c == '+' || c == '-') {
                if ((c == '+' || c == '-')) {
                    if (c != chars[0]) {
                        throw new RuntimeException("input str error");
                    }
                    symbol = c == '-' ? -1 : 1;
                    continue;
                }
                num = num * 10 + (c - '0');
                if (num > Integer.MAX_VALUE) {
                    throw new RuntimeException("str to long for input");
                }
            } else {
                throw new RuntimeException("str is error for " + c);

            }


        }
        return (int) num * symbol;
    }

    //简单测试下
    public static void main(String[] args) {
        System.out.println(strToInt("1948243") == 1948243);
        System.out.println(strToInt("+1948243") == 1948243);
        System.out.println(strToInt("-1948243") == -1948243);
        System.out.println(strToInt("-0") == 0);
        //System.out.println(strToInt("-194+8243") == 0);
        //System.out.println(strToInt("") == 0);
        //System.out.println(strToInt(null) == 0);
        //System.out.println(strToInt("999999999999999") == 0);
        System.out.println(strToInt("+") == 0);

        System.out.println(strToInt("2147483647") == 2147483647); //0x7FFFFFFF
        //System.out.println(strToInt("2147483648") == 0);

        //System.out.println(strToInt("-2147483648") == -2147483648); //0x80000000
        //System.out.println(strToInt("-2147483649") == 0);
    }
}