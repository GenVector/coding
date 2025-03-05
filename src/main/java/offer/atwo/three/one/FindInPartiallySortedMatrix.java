package offer.atwo.three.one;

/**
 * 寻找二维数组中所在的位置
 * 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find(matrix, 1);
    }

    public static void find(int[][] matrix, int a) {
        // ......异常检查
        int row = 0; // 行数
        int column = matrix[0].length - 1; // 列数
        while (row >= 0 && row <= matrix[0].length - 1 && column >= 0 && column <= matrix[0].length - 1) {
            if (a == matrix[row][column]) {
                System.out.println(row + ":" + column);
                return;
            } else if (a > matrix[row][column]) {
                row++;
            } else {
                column--;
            }
        }
        System.out.println("数组中不含数字：" + a);
    }
}
