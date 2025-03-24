package leetcode;

import offer.atwo.three.three.ListNode;

import java.util.List;

/*
 * LeetCode第23号问题：合并K个排序链表
 */
public class Q23 {
}

class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        if (lists.size() == 2) {
            return mergeTwoLists(lists.get(0), lists.get(1));
        }
        int mid = lists.size() / 2;
        List<ListNode> l1 = new java.util.ArrayList<>(lists.subList(0, mid));
        List<ListNode> l2 = new java.util.ArrayList<>(lists.subList(mid, lists.size()));
        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return head.next;

    }

    /*
     * 合并N个有序链表
     */
    public static ListNode mergeTwoListsK2(List<ListNode> nodes, int left, int right) {

        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        if (nodes.size() == 2) {
            return mergeTwoLists2(nodes.get(0), nodes.get(1));
        }

        int i = left;
        int j = right;

        while (i < j) {

            ListNode node = mergeTwoLists2(nodes.get(i), nodes.get(j));
            nodes.set(i, node);
            i++;
            j--;
        }

        if (i == j) {
            if (i == left) {
                return nodes.get(i);
            }
            return mergeTwoListsK2(nodes, left, i);
        } else {
            if (j == left) {
                return nodes.get(j);
            }
            return mergeTwoListsK2(nodes, left, j);
        }
    }


}