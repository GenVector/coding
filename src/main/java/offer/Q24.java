package offer;

import offer.atwo.three.three.ListNode;

import java.util.Stack;

import static offer.atwo.three.three.PrintListInReversedOrder.print;

//题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
public class Q24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(2))
                .setNext(new ListNode(3)).setNext(new ListNode(4))
                .setNext(new ListNode(5)).setNext(new ListNode(6))
                .setNext(new ListNode(7));
        listNode = ReverseList.reverseList3(listNode);
        print(listNode);
    }
}

class ReverseList {

    // 递归实现
    public static ListNode reverseList(ListNode head) {
        // 兜底 正常走不到
        if (head == null) {
            return null;
        }
        // 终止递归条件
        if (head.next == null) {
            return head;
        }
        // 找到最终的root 不变 永远是7 出栈逆序找到前一个元素
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode cur = stack.pop();
        ListNode newHead = cur;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}