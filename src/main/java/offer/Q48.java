package offer;

import java.util.HashMap;
import java.util.Map;

/*
 *题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4。
 */
public class Q48 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 确保左指针不回退（如abba的情况）
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right); // 更新字符最新位置
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "sadsfgswersty";
        int len = lengthOfLongestSubstring(str);
        System.out.println(len);
    }
}
