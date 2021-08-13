package offer.atwo.three.three;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return next;
    }
}

public class PrintListInReversedOrder {
    public static void reversePrint(ListNode node) {
        if (node.next != null) {
            reversePrint(node.next);
        }
        System.out.print(node.val + " | ");
    }

    public static void print(ListNode node) {
        System.out.print(node.val + " | ");
        if (node.next != null) {
            print(node.next);
        }
    }

    static ListNode revNode;
    static ListNode rootNode;

    public static ListNode reverse(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        if (stack.size() == 0) {
            throw new RuntimeException("node is null");
        }
        ListNode resNode = stack.pop();
        ListNode tem = resNode;
        while (stack.size() > 0) {
            tem.next = stack.pop();
            tem = tem.next;
        }
        tem.setNext(null);
        return resNode;
    }

    public static ListNode reverse2(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode tem = reverse2(node.next);
        tem.setNext(node);
        node.setNext(null);
        return node;
    }

    public static ListNode reverse3(ListNode node) {

        ListNode tem;
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4)).setNext(new ListNode(5));

        listNode = reverse2(listNode);
        print(listNode);

    }

}
