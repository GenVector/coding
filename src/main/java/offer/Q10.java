package offer;

/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class Q10 {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 12, 3, 4, 5};
        //int[] arr = {1, 1, 1, 1, 1, 1};
        System.out.println(MinNumberInRotatedArray.minNumberInRotateArray(arr));
    }

}

class MinNumberInRotatedArray {

    public static int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr error");
        }
        if (arr[arr.length - 1] > arr[0]) {
            return arr[0];
        }
        if (arr[arr.length - 1] == arr[0] && arr[0] == arr[(arr.length - 1) / 2]) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return arr[i + 1];
                }
            }
            return arr[0];
        }
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (high - low == 1) {
                break;
            }
            int mid = (high + low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid;
            }
            if (arr[mid] < arr[low]) {
                high = mid;
            }
        }
        return arr[high];
    }

}
