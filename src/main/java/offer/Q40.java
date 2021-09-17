package offer;

//题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
//这8个数字，则最小的4个数字是1、2、3、4。
public class Q40 {
}

class KLeastNumbers {
    public static int hetLeastNumbers1(int[] input, int k) {
        if (input == null || input.length == 0) {
            return -1;
        }
        if (k < 0 || k > input.length - 1) {
            return -1;
        }
        return hetLeastNumbers1(input, 0, input.length - 1, k);

    }

    public static int hetLeastNumbers1(int[] input, int start, int end, int k) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int i = start;
        int j = end;
        int index = input[start];
        while (i < j) {
            while (input[j] >= index && i < j) {
                j--;
            }
            while (input[i] <= index && i < j) {
                i++;
            }
            if (i < j) {
                int tem = input[i];
                input[i] = input[j];
                input[j] = tem;
            }

        }
        input[start] = input[i];
        input[i] = index;
        if (i > k) {
            return hetLeastNumbers1(input, start, i - 1, k);

        } else if (i < k) {
            return hetLeastNumbers1(input, i + 1, end, k);

        } else return input[i];
    }

    public static void main(String[] args) {
        int[] arr = {12, 7, 45, 5, 8, 9, 12, 33, 15};
        System.out.println(hetLeastNumbers1(arr, 5));
    }
}