package offer.atwo.three.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return left;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return right;
    }

    TreeNode left;
    TreeNode right;

    public static void main(String[] args) {
        TreeNode root = newTree1();
        System.out.println(level(root));
        preOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println("inOrder");
        inOrder(root);
        System.out.println();
        inOrder2(root);

        System.out.println("postOrder");
        postOrder(root);
        System.out.println("levelOrder");
        levelOrder(root);
    }

    public static void preOrder(TreeNode node) {
        System.out.print(node.val + " | ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public static void preOrder2(TreeNode treeNode) {
        System.out.println("preOrder2 ");
        Stack<TreeNode> list = new Stack<>();
        list.add(treeNode);
        while (list.size() > 0) {
            TreeNode tem = list.pop();
            System.out.print(tem.val + " | ");
            if (tem.right != null) {
                list.push(tem.right);
            }
            if (tem.left != null) {
                list.push(tem.left);
            }
        }
    }

    public static void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.val + " | ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    /*
              1
         2        5
      8    3         6
             4    7
           9
         10
     */
    public static void inOrder2(TreeNode node) {
        System.out.println("inOrder2 ");

        Stack<TreeNode> list = new Stack<>();
        while (list.size() > 0 || node != null) {
            if (node != null) {
                list.push(node);
                node = node.left;
            } else {
                node = list.pop();
                System.out.print(node.val + " | ");
                node = node.right;
            }
        }
    }

    public static void postOrder(TreeNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.val + " | ");
    }

    public static void postOrder2(TreeNode node) {

    }

    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> list = new LinkedList<>();
        list.add(node);
        while (list.size() > 0) {
            TreeNode tem = list.poll();
            System.out.print(tem.val + " | ");
            if (tem.left != null) {
                list.add(tem.left);
            }
            if (tem.right != null) {
                list.add(tem.right);
            }
        }
    }

    public static int level(TreeNode treeNode) {
        int left = 0;
        if (treeNode.left != null) {
            left = level(treeNode.left);
        }
        int right = 0;
        if (treeNode.right != null) {
            right = level(treeNode.right);
        }

        return left > right ? left + 1 : right + 1;
    }

    /*
              1
         2        5
      8    3         6
             4    7
           9
         10
     */
    public static TreeNode newTree1() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = root;
        treeNode.setRight(new TreeNode(5)).setRight(new TreeNode(6)).setLeft(new TreeNode(7));
        treeNode = treeNode.setLeft(new TreeNode(2));
        treeNode.setLeft(new TreeNode(8));
        treeNode.setRight(new TreeNode(3)).setRight(new TreeNode(4)).setLeft(new TreeNode(9)).setLeft(new TreeNode(10));
        return root;
    }

}
