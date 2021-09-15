package offer;

import java.util.Arrays;

//题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
//奇数位于数组的前半部分，所有偶数位于数组的后半部分。
public class Q21 {
}

class ReorderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (array[begin] % 2 != 0) {
                begin++;
            }
            while (array[end] % 2 == 0) {
                end--;
            }
            if (begin < end) {
                int tem = array[begin];
                array[begin] = array[end];
                array[end] = tem;
            }
        }
    }

    void test1() {
        int[] array = null;
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test2() {
        int[] array = {};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test3() {
        int[] array = {-2, 4, -6, 1, -3, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test4() {
        int[] array = {-1, 3, -5, 2, -4, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test5() {
        int[] array = {-1, 2, -3, 4, -5, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test6() {
        int[] array = {2, 2, 1, 3, 4, 1};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test7() {
        int[] array = {1};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderArray demo = new ReorderArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
