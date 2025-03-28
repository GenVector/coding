package offer;

import tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static tree.btree.TreeNode.newTree1;

public class Q34 {
}

// 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
class PathInTree {
    public static void findPath(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.val > target) {
            return;
        }
        if (root.val == target) {
            System.out.print(root.val + " | ");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        findPath(root.left, target - root.val, stack);
        findPath(root.right, target - root.val, stack);

    }

    public static void findPath(TreeNode root, int target, Stack<TreeNode> stack) {
        if (root == null || root.val > target) {
            return;
        }
        if (root.val == target) {
            stack.push(root);
            for (TreeNode treeNode : stack) {
                System.out.print(treeNode.val + " | ");
            }
            System.out.println();
            stack.pop();
            return;
        } else {
            stack.push(root);
            findPath(root.left, target - root.val, stack);
            findPath(root.right, target - root.val, stack);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        TreeNode node = newTree1();
        findPath(node, 11);
    }

}

class PathInTree2 {
    public static List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        findPath(root, target, paths, new ArrayList<>());
        return paths;
    }

    public static void findPath(TreeNode root, int target, List<List<Integer>> paths, List<Integer> path) {
        path.add(root.val);
        if (target == root.val) {
            paths.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            findPath(root.left, target - root.val, paths, path);
        }
        if (root.right != null) {
            findPath(root.right, target - root.val, paths, path);
        }
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode node = newTree1();
        List<List<Integer>> paths = findPath(node, 19);
        for (List<Integer> path : paths) {
            for (Integer i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}