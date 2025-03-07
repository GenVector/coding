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

    public static void levelOrder(tree.btree.TreeNode node) {

        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {
        };
        queue.add(node);
        while (!queue.isEmpty()) {
            tree.btree.TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return head.next;

    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        node1.setNext(new ListNode(2)).setNext(new ListNode(6)).setNext(new ListNode(7));
        ListNode node2 = new ListNode(1);
        node2.setNext(new ListNode(3)).setNext(new ListNode(4)).setNext(new ListNode(5));
        ListNode node3 = mergeTwoLists2(node1, node2);
        while (node3 != null) {
            System.out.println(node3.val);
            node3 = node3.next;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsK(List<ListNode> nodes) {

        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        if (nodes.size() == 2) {
            return mergeTwoLists(nodes.get(0), nodes.get(1));
        }
        int i = 0;
        int j = nodes.size() - 1;
        int mid = (i + j) / 2;

        List<ListNode> l1 = Lists.newArrayList(nodes.subList(0, mid));
        List<ListNode> l2 = Lists.newArrayList(nodes.subList(mid, nodes.size()));

        return mergeTwoLists2(mergeTwoListsK(l1), mergeTwoListsK(l2));

    }
}
