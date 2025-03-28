package coding2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement2 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        // 使用最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除堆顶的最小元素
            }
        }

        return minHeap.peek(); // 堆顶即为第 k 大的元素
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4}; // 示例数组
        int k = 2; // 找出第 2 大的数
        int result = findKthLargest(nums, k);
        System.out.println("第 " + k + " 大的数是: " + result);
    }

    public static int findKthLargest2(int[] nums, int k) {
        int a = Arrays.stream(nums).sorted().skip(nums.length - k).findFirst().orElseThrow();
        return a;

    }
}