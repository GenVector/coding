package offer.atwo.three.three;

import java.util.Stack;



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

    //利用栈后进先出
    public static ListNode reverse(ListNode node) {
        Stack<ListNode> stack = new Stack<ListNode>();
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

    //递归实现
    public static ListNode reverse2(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        ListNode root = reverse2(node.next);
        ListNode tem = root;
//        while (tem.next != null) {
//            tem = tem.next;
//        }
//        tem.setNext(node);
        node.next.next = node;
        node.next = null;
        return root;
    }

    //三指针标记遍历实现
    public static ListNode reverse3(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pNode = node;
        ListNode preNode = null;
        while (pNode != null) {
            ListNode nextNode = pNode.next;
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
        }
        return preNode;
    }

    public static ListNode reverse4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rvsHead = reverse4(head.next);
        head.next.next = head;
        head.next = null;
        return rvsHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(7)).setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4)).setNext(new ListNode(5));
        listNode = reverse2(listNode);
        print(listNode);
    }

}
