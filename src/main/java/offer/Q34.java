package offer;

import offer.atwo.three.three.TreeNode;

import java.util.Stack;

import static offer.atwo.three.three.TreeNode.newTree1;

public class Q34 {
}

//题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
//有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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
        findPath(node, 10);
    }

}