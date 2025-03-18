package offer;

import tree.btree.TreeNode;

//题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class Q27 {
}

class MirrorOfBinaryTree {
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else {
            TreeNode tem = root.right;
            root.right = root.left;
            root.left = tem;
        }
        mirror(root.right);
        mirror(root.left);

    }

    public static TreeNode rev(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = rev(node.left);
        TreeNode right = rev(node.right);
        node.left = right;
        node.right = left;
        return node;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
//        TreeNode.levelOrderByLevel(root);
        System.out.println();
        Q32.levelOrderZ(root);
        mirror(root);

        System.out.println();
//        TreeNode.levelOrderByLevel(root);
        System.out.println();
        Q32.levelOrderZ(root);
    }

}