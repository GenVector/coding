package coding2;

/*
 * 查找两个字符串a,b中的最长公共子串
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {

        String s1 = "a1b11cdfghg11g";
        String s2 = "abdfab1cdfghg11gghsabcdfghf";
        System.out.println(longestCommonSubstring(s1, s2));
    }

    /*
     * 暴力解法
     */
    public static String longestCommonSubstring(String s1, String s2) {

        String max = "";

        for (int i = 0; i < s1.length(); i++) {

            for (int j = 0; j < s2.length(); j++) {
                String temp = "";
                int k = i;
                while (k < s1.length() && j < s2.length() && s1.charAt(k) == s2.charAt(j)) {
                    temp += s1.charAt(k);
                    if (temp.length() > max.length()) {
                        max = temp;
                    }
                    k++;
                    j++;

                }
            }
        }
        return max;
    }


}

/*
 * 动态规划解法
 */
class LongestCommonSubstring2 {
    public static void main(String[] args) {
        String s1 = "a1b11cdfsabcdfg2ghg11g";
        String s2 = "sabcdfg22hfg";
        System.out.println(longestCommonSubstring(s1, s2));
    }

    public static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int index = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return s1.substring(index - maxLength, index);
    }
}
