package offer;

import offer.atwo.three.three.ListNode;

import static offer.atwo.three.three.PrintListInReversedOrder.print;

//题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
public class Q24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(7)).setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4)).setNext(new ListNode(5));
        listNode = ReverseList.reverseList2(listNode);
        print(listNode);
    }
}

class ReverseList {

    //递归实现
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode pNode = head;
        while (pNode != null) {
            ListNode next = pNode.next;
            pNode.next = preNode;
            preNode = pNode;
            pNode = next;
        }
        return preNode;
    }
}