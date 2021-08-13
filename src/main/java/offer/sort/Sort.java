package offer.sort;

import java.util.Arrays;

class Sort {
    public static void main(String[] args) {

        int[] arr = {6, 4, 8, 6, 1, 4, 12, 3, 6, 8, 9, 22, 2};
        quickSort(arr, 0, arr.length - 1);
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
    public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        if (array == null || array.length < 1)
            return;
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;
        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}
