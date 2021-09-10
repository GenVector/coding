package sort;

import java.util.Arrays;

class Sort {
    public static void main(String[] args) {

        int[] arr = {6, 4, 8, 6, 1, 4, 12, 3, 6, 8, 9, 22, 2};
//        insertSort(arr);
        quickSort(arr);
//        popSort(arr);
//        selectSort(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " | "));
    }

    public static void popSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            int tem = arr[maxIndex];
            arr[maxIndex] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tem;
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        if (array == null || array.length < 1) {
            return;
        }
        int key = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            // !!! 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= key && i < j) {
                j--;
            }
            while (array[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                int tem = array[i];
                array[i] = array[j];
                array[j] = tem;
            }
        }
        array[left] = array[j];
        array[j] = key;
        quickSort(array, left, j - 1);
        quickSort(array, i + 1, right);

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];
            while (j > 0 && arr[j - 1] > target) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeArray(arr, left, mid + 1, right);

    }

    public static void mergeArray(int[] arr, int left, int mid, int right) {
        for (int i = left; i < mid; i++) {
            if (arr[i] < arr[mid]) {
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[mid];
            arr[mid] = temp;
            int j = mid;
            while (j < right - 1 && arr[j] > arr[j + 1]) {
                int tem = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tem;
                j++;
            }

        }
    }


}
