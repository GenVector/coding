package coding2;

import offer.atwo.three.three.ListNode;

/**
 * 两个链表分别表示两个数，对这两个链表加和，产生一个新的链表
 */
public class AddListNode {
    public static void main(String[] args) {
        // 852
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(8);

        l1.setNext(l2).setNext(l3);

        // 5115
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(5);
        l4.setNext(l5).setNext(l6).setNext(l7);
        ListNode l8 = add(l1, l4);

        while (l8 != null) {
            System.out.println(l8.val);
            l8 = l8.next;
        }

    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode head = current;
        int next = 0;

        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            int cur = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            cur = num1 + num2 + next;
            current.val = cur % 10;
            if (cur >= 10) {
                next = 1;
            }
            if (l1 != null || l2 != null) {
                ListNode temp = new ListNode(0);
                current.setNext(temp);
                current = temp;
            }

        }
        return head;
    }
}
