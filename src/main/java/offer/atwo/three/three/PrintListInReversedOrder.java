package offer.atwo.three.three;

import java.util.Stack;

import static offer.atwo.three.three.PrintListInReversedOrder.print;

//题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
class Q5 {

}

public class PrintListInReversedOrder {

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
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        if (stack.isEmpty()) {
            throw new RuntimeException("node is null");
        }
        ListNode resNode = stack.pop();
        ListNode tem = resNode;
        while (!stack.isEmpty()) {
            tem.next = stack.pop();
            tem = tem.next;
        }
        tem.setNext(null);
        return resNode;
    }

}

//从尾到头打印链表
class ReversePrint1 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(7))
                .setNext(new ListNode(2))
                .setNext(new ListNode(3))
                .setNext(new ListNode(4))
                .setNext(new ListNode(5));
        reversePrint2(listNode);
    }

    public static void reversePrint1(ListNode node) {
        Stack<ListNode> nodes = new Stack<>();
        while (node != null) {
            nodes.push(node);
            node = node.next;
        }
        while (!nodes.empty()) {
            node = nodes.pop();
            System.out.print(node.val + " | ");

        }
    }

    public static void reversePrint2(ListNode node) {
        if (node == null) {
            return;
        }
        reversePrint2(node.next);
        System.out.print(node.val + " | ");
    }

}

class T2 {


    public static ListNode reverse(ListNode node) {
        Stack<ListNode> nodes = new Stack<>();
        while (node != null) {
            nodes.push(node);
            node = node.next;
        }
        if (nodes.isEmpty()) {
            return null;
        }
        ListNode res = nodes.pop();
        ListNode cur = res;
        while (!nodes.empty()) {
            ListNode tem = nodes.pop();
            tem.next = null;
            cur.next = tem;
            cur = cur.next;
        }
        return res;
    }

    public static ListNode reverse2(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }
}
