package arr;

public class MaxSubArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 2, -6, 3, 11, 4, -3, -13, 4, 8, -11, 9, 12};
        maxSubArr(arr);
    }

    // 动态规划
    public static void maxSubArr(int[] arr) {
        // 初始化最大值为数组的第一个元素
        int max = arr[0];
        // 初始化当前子数组和为数组的第一个元素
        int sum = arr[0];
        // 遍历数组
        for (int i = 1; i < arr.length; i++) {
            // 如果当前子数组和大于0，则继续累加当前元素
            if (sum > 0) {
                sum += arr[i];
            } else {
                // 如果当前子数组和小于等于0，则重新开始计算新的子数组和
                sum = arr[i];
            }
            // 更新最大值
            max = max(arr[i], sum, max);
        }
        // 输出最大值
        System.out.println(max);
    }


    // 穷举法
    public static void maxSubArr2(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    public static int max(int a, int b, int c) {
        if (a > b) {
            return Math.max(a, c);
        } else {
            return Math.max(b, c);
        }
    }


    // 获取和右侧子数组最大差值
    public static void getMaxRightArrSub(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("arr error");
        }
        int max = Math.max(arr[0], arr[1]);
        int diff = arr[0] - arr[1];
        for (int i = 2; i < arr.length; i++) {
            diff = Math.max(diff, max - arr[i]);
            max = Math.max(max, arr[i]);

        }
        System.out.println(diff);

    }


}
