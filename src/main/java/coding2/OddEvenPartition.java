package coding2;

/*
 * 输入一个 int 数组，返回一个数组，其中奇数都在左边，偶数都在右边
 */
public class OddEvenPartition {
    public static int[] partitionOddEven(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0; // 左指针
        int right = nums.length - 1; // 右指针

        while (left < right) {
            // 移动左指针，直到找到一个偶数
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }

            // 移动右指针，直到找到一个奇数
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            // 交换左右指针的元素
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 示例数组
        int[] result = partitionOddEven(nums);

        // 输出结果
        System.out.print("分区后的数组: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

/*
 * 如果要求奇数部分和偶数部分的相对顺序不变，可以使用以下方法
 * 创建一个新数组，遍历原数组两次，第一次放入奇数，第二次放入偶数
 */
class OddEvenPartitionStable {
    public static int[] partitionOddEvenStable(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        int index = 0;

        // 第一次遍历，放入奇数
        for (int num : nums) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }

        // 第二次遍历，放入偶数
        for (int num : nums) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 示例数组
        int[] result = partitionOddEvenStable(nums);

        // 输出结果
        System.out.print("分区后的数组（保持顺序）: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /*
     * 以下是手敲
     */
    public static void find(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            // 判断是否是偶数
            if (arr[i] % 2 == 0) {
                i++;
            }
            // 判断是否是奇数
            if (arr[j] % 2 != 0) {
                j--;
            }

            if (i < j && arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}