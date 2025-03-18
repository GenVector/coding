package offer;

import org.junit.Test;

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
// 螺旋打印矩阵问题
public class Q29 {
    @Test
    public void test() {
        int[][] a = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        PrintMatrix.printMatrixInCircle2(a);
    }
}

class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0)
            return;
        printMatrixInCircle(matrix, 0);
        System.out.println();
    }

    public static void printMatrixInCircle(int[][] matrix, int start) {
        int row = matrix.length;
        int col = matrix[0].length;
        int startX = start;
        int startY = start;
        if (start >= col - start || start >= row - start) {
            return;
        }
        if (startX < col - start && startY < row - start && startX >= 0 && startY >= 0) {
            for (; startX < col - start; startX++) {
                System.out.print(matrix[startY][startX] + " | ");
            }
            startX--;
        }

        startY++;
        if (startX < col - start && startY < row - start && startX >= 0 && startY >= 0) {
            for (; startY < row - start; startY++) {
                System.out.print(matrix[startY][startX] + " | ");
            }
            startY--;
        }

        startX--;
        if (startX < col - start && startY < row - start && startX >= 0 && startY >= 0) {
            for (; startX >= start; startX--) {
                System.out.print(matrix[startY][startX] + " | ");
            }
            startX++;
        }
        startY--;
        if (startX < col - start && startY < row - start && startX >= 0 && startY >= 0) {

            for (; startY > start; startY--) {
                System.out.print(matrix[startY][startX] + " | ");
            }
        }
        printMatrixInCircle(matrix, start + 1);

    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(a);
        int[][] a1 = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(a1);
        int[][] a2 = {{}};
        printMatrix(a2);
        int[][] a3 = {{1}};
        printMatrix(a3);
        int[][] a4 = {{1, 2, 3, 4}};
        printMatrix(a4);
        int[][] a5 = {{1}, {2}, {3}, {4}};
        printMatrix(a5);

        int[][] a6 = {{1, 2, 3}, {4, 5, 6}};
        printMatrix(a6);
        int[][] a7 = null;
        printMatrix(a7);
    }



    public static void printMatrixInCircle2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " | ");
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " | ");
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " | ");
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " | ");
            }
            left++;
        }
    }
}