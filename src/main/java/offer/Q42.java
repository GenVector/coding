package offer;

//题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
//数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
public class Q42 {
}

class GreatestSumOfSubarrays {
    public static int findGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : array) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, Math.max(num, max));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, -5, 2, 5, -11, 15, 1, -5};
        System.out.println(findGreatestSumOfSubArray(arr));
    }
}