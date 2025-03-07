package offer;

/*  回溯法
    后进先出
 */
public class Q11 {
    public static void main(String[] args) {
        StringPathInMatrix demo = new StringPathInMatrix();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}

/*
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 */
class StringPathInMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] isVisited = new boolean[rows * cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二维数组下标的计算：row*cols+col
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col]
                || str[pathLength] != matrix[row * cols + col]) {
            return false;

        }
        if (pathLength == str.length - 1) {
            return true;
        }
        boolean hasPath = false;
        isVisited[row * cols + col] = true;
        hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);

        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }

    // BFCTB
    public void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

    // A B T G
    // C F C S
    // J D E H

    // BFCE
    public void test2() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }

    // matrix=null
    public void test3() {
        char[] matrix = null;
        int rows = 0;
        int cols = 0;
        char[] str = "BFCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }

    // str=null
    public void test4() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = null;
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }

    // A

    // A
    public void test5() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "A".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }

    // A

    // B
    public void test6() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "B".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }

    // AAAA
    // AAAA
    // AAAA

    // AAAAAAAAAAAA
    public void test7() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }

    int rows;
    int cols;
    int row;
    int col;
    int index = row * cols + col;

    public static boolean hasPath2(char[] strs, int rows, int cols, char[] path) {
        if (strs == null || strs.length == 0 || path == null || path.length == 0 || rows == 0 || cols == 0) {
            return false;
        }
        boolean[] isVisited = new boolean[rows * cols + 1];

        int pathLen = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (core(strs, path, rows, cols, row, col, isVisited, pathLen)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean core(char[] strs, char[] path, int rows, int cols, int row, int col, boolean[] isVisited, int pathLen) {
        if (strs == null || strs.length == 0 || path == null || path.length == 0 || col < 0 || row < 0 || row >= rows || col >= cols
                || isVisited[row * cols + col]) {
            return false;
        }
        if (strs[row * cols + col] != path[pathLen]) {
            return false;
        }
        if (pathLen == path.length - 1) {
            return true;
        }
        boolean hasPath = false;
        isVisited[row * cols + col] = true;

        hasPath = core(strs, path, rows, cols, row, col + 1, isVisited, pathLen + 1) || core(strs, path, rows, cols, row, col - 1, isVisited, pathLen + 1)
                || core(strs, path, rows, cols, row + 1, col, isVisited, pathLen + 1) || core(strs, path, rows, cols, row - 1, col, isVisited, pathLen + 1);

        if (!hasPath) {
            isVisited[row * cols + col] = false;

        }
        return hasPath;
    }
}

