package coding2;

/*
一个顺序递增的数组，内含重复的数，现查找一个给定的数在不在数组，在的话给出最后一个出现的 index
 */
public class FindLastOccurrence {
    public static int findLastOccurrence(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; // 数组为空，直接返回 -1
        }

        int left = 0;
        int right = nums.length - 1;
        int result = -1; // 用于存储最后一个出现的索引

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出

            if (nums[mid] == target) {
                result = mid; // 找到目标值，记录索引
                left = mid + 1; // 继续在右半部分查找是否有更大的索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }

        return result; // 返回最后一个出现的索引，未找到则返回 -1
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 4, 5, 6, 8}; // 示例数组
        int target = 8; // 目标值
        int index = findLast(nums, target);

        if (index != -1) {
            System.out.println("最后一个出现的索引是: " + index);
        } else {
            System.out.println("目标值不在数组中");
        }
    }

    /*
     * 手打
     */
    public static int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                idx = mid;
                while (idx < nums.length - 1 && nums[idx + 1] == target) {
                    idx++;
                }
                return idx;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        return idx;
    }
}

