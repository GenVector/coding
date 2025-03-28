package offer;

import tree.btree.TreeNode;
/*
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Q26 {
}

class SubstructureInTree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return equals(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    //比较是否相等 | 或者root2为空
    public boolean equals(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return root1.val == root2.val && equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }
}
