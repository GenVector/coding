package offer.atwo.three.one;

public class RepeatNumber {
    public static void main(String[] args) {
        int[] arr = {2, 0, 3, 1, 5, 9, 8, 4, 7, 6, 7};
        //int[] arr = {2,3,1,0,2,5,3};
        int num = getRepeatNumber(arr);
        System.out.println(num);
    }


    public static int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
            int temp;
            while (arr[i] != i) {
                int m = arr[i];
                if (arr[m] == m) {
                    return arr[i];
                }
                // 交换arr[arr[i]]和arr[i]
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        System.out.println("数组中无重复数字！");
        return -1;
    }


    public static int getRepeatNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
            while (arr[i] != i) {
                int m = arr[i];
                if (arr[m] == m) {
                    return m;
                } else {
                    int tem = arr[m];
                    arr[m] = m;
                    arr[i] = tem;
                }
            }
        }
        return -1;
    }
}
