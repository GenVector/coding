package offer.atwo.three.three;

public class ReplaceSpaces {
    /*
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
     * 由于Java中String是final class。所以可以新建一个StringBuilder处理。
     * 如果入出参是类似char数组的形式,可以先找出空格数量
     *
     */
}

//合并数组
//考虑从后往前,可减少移动次数
//等同于借助了额外空间
class MergeArr {

    public static void main(String[] args) {
//        int[] arr = new int[5];
//        System.out.println(arr[0]);
        int[] arrA = new int[8];
        arrA[0] = 4;
        arrA[1] = 5;
        arrA[2] = 9;

        int[] arrB = {1, 2, 3, 6, 8, 10};
        merge(arrA, 3, arrB, 5);
        for (int a : arrA) {
            System.out.print(a + " | ");
        }
    }

    //注意边界控制
    public static void merge(int[] arrA, int aLength, int[] arrB, int bLength) {
        int i = aLength - 1;
        int j = bLength - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0) {
                arrA[i + j + 1] = arrA[i];
                //arrA[i] = -1;
                i--;
                continue;
            } else if (i < 0) {
                arrA[i + j + 1] = arrB[j];
                j--;
                continue;
            }
            if (arrA[i] > arrB[j]) {
                arrA[i + j + 1] = arrA[i];
                //arrA[i] = -1;
                i--;
            } else {
                arrA[i + j + 1] = arrB[j];
                //arrB[j] = -1;
                j--;
            }
        }
    }

}
