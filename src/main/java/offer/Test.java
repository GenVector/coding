package offer;

import offer.atwo.three.three.ListNode;

public class Test {

    //1->2->3->4->5
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1 = resLinkedList(node1);
        while (node1 != null) {
            System.out.println(node1.val + " | ");
            node1 = node1.next;
        }
    }

    public static ListNode resLinkedList(ListNode node) {
        if (node == null) {
            throw new RuntimeException("input node error");
        }
        ListNode pNode = node;
        ListNode preNode = null;
        while (pNode != null) {
            ListNode next = pNode.next;
            pNode.next = preNode;
            preNode = pNode;
            pNode = next;
        }
        return preNode;

    }
}

