package offer.atwo.three.one;

public class RepeatNumberTwo {
    /**
     * 找到数组中一个重复的数字
     * 返回-1代表无重复数字或者输入无效
     */
    public static int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length - 1; // high即为题目的n
        int mid, count;
        while (low <= high) {
            mid = ((high - low) >> 2) + low;
            count = countRange(arr, low, mid);
            if (low == high) {
                if (count > 1)
                    return low;
                else
                    break; // 必有重复，应该不会出现这种情况吧？
            }
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 返回在[low,high]范围中数字的个数
     */
    public static int countRange(int[] arr, int low, int high) {
        if (arr == null)
            return 0;

        int count = 0;
        for (int a : arr) {
            if (a >= low && a <= high)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] arr = {2, 3, 1, 5, 9, 8, 4, 7, 6, 7};
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        int num = getDuplicate(arr);
        System.out.println(num);
    }
}
