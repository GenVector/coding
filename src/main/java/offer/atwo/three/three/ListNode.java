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


}
