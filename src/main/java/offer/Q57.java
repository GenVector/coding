package offer;


import java.util.ArrayList;

public class Q57 {

    /**
     * 剑指 Offer 57. 和为s的两个数字
     */
    public static int[] findTwo(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        if (target < nums[0]) {
            return null;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (target == start + end) {
                return new int[]{start, end};
            } else if (target < start + end) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }
    /*
     * 剑指 Offer 57 - II. 和为s的连续正数序列
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //从1到2的区间开始
        for (int l = 1, r = 2; l < r; ) {
            //计算区间内的连续和
            int sum1 = (l + r) * (r - l + 1) / 2;
            //如果区间内和等于目标数
            if (sum1 == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                //记录区间序列
                for (int i = l; i <= r; i++)
                    temp.add(i);
                res.add(temp);
                //左区间向右
                l++;
                //如果区间内的序列和小于目标数，右区间扩展
            } else if (sum1 < sum)
                r++;
                //如果区间内的序列和大于目标数，左区间收缩
            else
                l++;
        }
        return res;
    }

}
