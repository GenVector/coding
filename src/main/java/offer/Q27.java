package offer;

import tree.btree.TreeNode;

//题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class Q27 {
}

class MirrorOfBinaryTree {
    public void mirror(TreeNode root) {
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

}