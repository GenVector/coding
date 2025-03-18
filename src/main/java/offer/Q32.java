package offer;

import tree.btree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q32 {
    public static void levelOrderZ(TreeNode root) {
        Queue[] queue = new LinkedList[2];
        queue[0] = new LinkedList<TreeNode>();
        queue[1] = new LinkedList<TreeNode>();
        int cur = 0, next = 1;
        int idx = cur;
        queue[cur].add(root);


        while (!queue[cur].isEmpty() || !queue[next].isEmpty()) {
            TreeNode node = (TreeNode) queue[idx].poll();

            System.out.print(node.val + " | ");
            if (idx == cur) {

                if (node.left != null) {
                    queue[next].add(node.left);
                }
                if (node.right != null) {
                    queue[next].add(node.right);
                }
            } else {

                if (node.right != null) {
                    queue[cur].add(node.right);
                }
                if (node.left != null) {
                    queue[cur].add(node.left);
                }

            }
            if (queue[idx].isEmpty()) {
                idx = idx == 0 ? 1 : 0;
                System.out.println();
            }


        }

    }

    public static void main(String[] args) {

    }

}
