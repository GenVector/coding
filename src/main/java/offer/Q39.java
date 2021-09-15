package offer;

//题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
//如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
//出现了5次，超过数组长度的一半，因此输出2。
public class Q39 {
}

class MoreThanHalfNumber {
    boolean isInputInvalid = true;

    //方法一：partition方法
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int index = partition(array, low, high);
        while (index != array.length >> 1) {
            if (index < array.length >> 1) {
                low = index + 1;
                index = partition(array, low, high);
            } else {
                high = index - 1;
                index = partition(array, low, high);
            }
        }
        //判断次数是否超过一半
        int num = array[index];
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            }
        }
        if (times * 2 > array.length) {
            isInputInvalid = false;
            return num;
        }
        return 0;
    }

    private int partition(int[] array, int low, int high) {
        int pivotKey = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivotKey)
                high--;

            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;

            while (low < high && array[low] <= pivotKey)
                low++;
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        return low;
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int num = 0;
        int count = 0;
        for (int a : array) {
            if (a != num) {
                if (count > 1) {
                    count--;
                } else {
                    num = a;
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return num;
    }

//    public static void main(String[] args) {
//        int a = 1111111;
//        int b = 1111111;
//        Integer c = new Integer(1111111);
//        Integer d = new Integer(1111111);
//        Integer e = new Integer(11);
//        Integer f = new Integer(11);
//        Integer g = 11;
//        Integer h = 11;
//
//        System.out.println("" + (a == b));
//        System.out.println("" + (a == c));
//        System.out.println("" + (d == c));
//        System.out.println("" + (f == e));
//        System.out.println("" + (g == h));
//        System.out.println("" + (g == h));
//
//    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 1, 1, 6, 6, 6, 6, 6, 6, 6, 1};
        int num = MoreThanHalfNum_Solution2(ints);
        System.out.println(num);
    }
}
