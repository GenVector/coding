package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 判断一个数字是否是回文数
 */
public class Q9 {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
