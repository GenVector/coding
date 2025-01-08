package offer.atwo.three.three;

import tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//已知二叉树的前序遍历和中序遍历还原二叉树
public class ConstructBinaryTree {


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || in.length <= 0 || pre.length != in.length) {
            throw new RuntimeException("数组不符合规范！");
        }
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        TreeNode node = new TreeNode(pre[pStart]);
        if (pEnd < 0 || iEnd < 0) {
            throw new RuntimeException("数组不符合规范！");
        }
        if (pStart > pEnd || iStart > iEnd) {
            throw new RuntimeException("数组不符合规范！");
        }
        if (pStart == pEnd && iStart == iEnd) {
            return node;
        }
        for (int i = iStart; i <= iEnd; i++) {
            if (in[i] == pre[pStart]) {
                int moveIndex = i - iStart;
                if (i > iStart) {
                    node.left = construct(pre, in, pStart + 1, pStart + moveIndex, iStart, i - 1);
                }
                if (i < iEnd) {
                    node.right = construct(pre, in, pStart + moveIndex + 1, pEnd, i + 1, iEnd);
                }
                return node;
            }
        }
        throw new RuntimeException("数组不符合规范！");
    }

    //二叉树镜像
    public static void mirrorRecursively(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right != null) {
            node.left = node.right;
            node.right = null;
            mirrorRecursively(node.left);
        } else if (node.left != null && node.right == null) {
            node.right = node.left;
            node.left = null;
            mirrorRecursively(node.right);
        } else {
            TreeNode tem = node.right;
            node.right = node.left;
            node.left = tem;
            mirrorRecursively(node.right);
            mirrorRecursively(node.left);
        }
    }

    //打印左视图
    public static void leftViewPrint(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        leftView(node, list, 0);
        for (TreeNode a : list) {
            System.out.print(a.val + " | ");
        }

    }

    public static void leftView(TreeNode node, List<TreeNode> list, Integer level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node);
        }
        leftView(node.left, list, level + 1);
        leftView(node.right, list, level + 1);
    }

    //打印右视图
    public static void rightViewPrint(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        rightView(node, list, 0);
        for (TreeNode a : list) {
            System.out.print(a.val + " | ");
        }

    }

    public static void rightView(TreeNode node, List<TreeNode> list, Integer level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node);
        }
        rightView(node.right, list, level + 1);
        rightView(node.left, list, level + 1);
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(preOrder, inOrder);
        TreeNode.levelOrder(treeNode);
        mirrorRecursively(treeNode);
        System.out.println();
        TreeNode.levelOrder(treeNode);
        System.out.println();
        //treeNode = TreeNode.newTree1();
        leftViewPrint(treeNode);
        System.out.println();
        rightViewPrint(treeNode);

    }

}
