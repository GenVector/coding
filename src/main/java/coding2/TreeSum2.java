package coding2;

import com.google.common.collect.Lists;
import offer.atwo.three.three.ListNode;
import org.junit.Test;
import tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 二叉树中找出所有路径，使得路径上的节点值之和等于 21
 * 这个是剪枝法 也可以是个回溯法
 */
public class TreeSum2 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find(matrix, 9);
    }

    public static List<List<Integer>> pathSum(tree.btree.TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        sum(root, sum, currentPath, result);
        return result;
    }

    public static void sum(tree.btree.TreeNode root,
                           int num,
                           List<Integer> currentPath,
                           List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (root.val == num) {
            result.add(new ArrayList<>(currentPath));
        }
        sum(root.left, num - root.val, currentPath, result);
        sum(root.right, num - root.val, currentPath, result);
        currentPath.remove(currentPath.size() - 1);
    }

    public static void find(int[][] nums, int idx) {
        int i = 0;
        int j = nums[1].length - 1;
        while (i < nums[0].length && j >= 0) {
            if (nums[i][j] == idx) {
                System.out.println(i + " " + j);
                return;
            }
            if (nums[i][j] < idx) {
                i++;
            }
            if (nums[i][j] > idx) {
                j--;
            }
        }
        System.out.println("数组中不含数字：" + idx);
    }

}
