package offer;

public class Q10 {
    public static void main(String[] args) {
        //int[] arr = {6, 7, 8, 12, 3, 4, 5};
        int[] arr = {1, 1, 1, 1, 1, 1};
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
