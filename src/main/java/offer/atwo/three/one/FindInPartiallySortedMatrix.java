package offer.atwo.three.one;

public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find(matrix, 7);
    }

    public static void find(int[][] matrix, int a) {
        //......异常检查
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
