package offer.atwo.three.three;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return next;
    }

    public static void reversePrint(ListNode node) {
        if (node == null) {
            return;
        }
        reversePrint(node.next);
        System.out.print(node.val + "->");
    }


    public static ListNode rev(ListNode node, int k) {
        if (node == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = node;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode revList(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }
        ListNode newHead = rev(head, k);
        head.next = revList(cur, k);
        return newHead;


    }


}
