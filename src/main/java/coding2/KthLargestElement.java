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
        // 擦 这儿变成了找length - k小的
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        // 如果左边界等于右边界，说明区域范围已经缩小到1，直接返回该元素
        if (left == right) {
            return nums[right];
        }


        // 对数组进行分区操作，返回 pivot 的最终位置
        // 分区后，所有小于 pivot 的元素都在其左侧，所有大于 pivot 的元素都在其右侧
        int pivotIndex = partition(nums, left, right);

        // 如果 k 等于 pivot 的索引，说明找到了第 k 小的元素，直接返回
        if (k == pivotIndex) {
            return nums[k];
            // 如果 k 小于 pivot 的索引，说明第 k 小的元素在 pivot 的左侧，递归地在左侧子数组中查找
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
            // 如果 k 大于 pivot 的索引，说明第 k 小的元素在 pivot 的右侧，递归地在右侧子数组中查找
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }


    private static int partition(int[] nums, int left, int right) {
        // 仍旧是正序排序 从小到大
        // 选择最右边的元素作为基准值
        int pivotValue = nums[right];
        // 存储小于基准值的元素的索引
        int storeIndex = left;
        // 遍历数组，将小于基准值的元素移到左侧
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                // 交换当前元素和存储索引位置的元素
                swap(nums, storeIndex, i);
                // 更新存储索引位置
                storeIndex++;
            }
        }

        // 将 pivot 移到最终位置
        swap(nums, storeIndex, right);
        // 返回基准值的最终位置
        return storeIndex;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 22, 11, 4, 2, 2, 1, 5, 6, 4, 13}; // 示例数组
        int k = 1; // 找出第 2 大的数
        int result = findKthLargest(nums, k);
        System.out.println("第 " + k + " 大的数是: " + result);
    }
}
