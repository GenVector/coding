package coding2;

import java.util.Random;
/*
找出数组中第 k 大的数 输入k,和数组，输出第k大的数
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        // 随机选择一个 pivot 的索引
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);

        // 分区操作，返回 pivot 的最终位置
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // 将 pivot 移到最右边
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // 将 pivot 移到最终位置
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4}; // 示例数组
        int k = 2; // 找出第 2 大的数
        int result = findKthLargest(nums, k);
        System.out.println("第 " + k + " 大的数是: " + result);
    }
}
