package offer;

import tree.btree.TreeNode;

import java.util.Objects;

// 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
public class Q28 {
}

class SymmetricalBinaryTree {
    public static boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }
        return equals(pRoot.right, pRoot.left);
    }

    public static boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {

            return true;
        }
        if (node1 == null || node2 == null) {

            return false;
        }

        return Objects.equals(node1.val, node2.val) &&
                equals(node1.right, node2.left) &&
                equals(node1.left, node2.right);
    }

}
