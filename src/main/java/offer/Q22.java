package offer;

import offer.atwo.three.three.ListNode;
import org.junit.Test;

import java.util.Stack;

// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。
public class Q22 {
}
/*
 * 思路：本题有三种解法:1.双指针法，2.栈，3.递归
 */
class KthNodeFromEnd {
    public ListNode findKthToTail1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode after = head;

        int i = 0;
        while (ahead != null && i < k) {
            ahead = ahead.next;
            i++;
        }
        if (i < k) {
            return null;
        }
        while (ahead != null) {
            ahead = ahead.next;
            after = after.next;
        }
        return after;
    }

    public ListNode findKthToTail2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty() && k > 0) {
            ListNode tem = stack.pop();
            k--;
            if (k == 0) {
                return tem;
            }
        }
        return null;

    }


    /*
     * null
     */
    void test1() {
        ListNode head = null;
        ListNode result = findKthToTail2(head, 1);
        if (result == null)
            System.out.println("test1 passed!");
        else
            System.out.println("test1 failed!");
    }

    /*
     * k超出范围
     */
    void test2() {
        ListNode head = new ListNode(2);
        ListNode result = findKthToTail2(head, 2);
        if (result == null)
            System.out.println("test2 passed!");
        else
            System.out.println("test2 failed!");
    }

    /*
     * 单个结点
     */
    void test3() {
        ListNode head = new ListNode(1);
        ListNode result = findKthToTail2(head, 1);
        if (result.val == 1)
            System.out.println("test3 passed!");
        else
            System.out.println("test3 failed!");
    }

    /*
     * 尾结点
     */
    void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = findKthToTail2(node1, 1);
        if (result.val == 4)
            System.out.println("test4 passed!");
        else
            System.out.println("test4 failed!");
    }

    /*
     * 中间结点
     */
    void test5() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = findKthToTail2(node1, 2);
        if (result.val == 3)
            System.out.println("test5 passed!");
        else
            System.out.println("test5 failed!");
    }

    /*
     * 头结点
     */
    void test6() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = findKthToTail2(node1, 4);
        if (result.val == 1)
            System.out.println("test6 passed!");
        else
            System.out.println("test6 failed!");
    }

    public static void main(String[] args) {
        KthNodeFromEnd demo = new KthNodeFromEnd();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
    }


    @Test
    public void getKthFromEnd() {
        // 这儿是个思路 返回值 数字+节点 即可返回node
        ListNode node1 = new ListNode(1);
        node1.setNext(new ListNode(2)).setNext(new ListNode(6)).setNext(new ListNode(7));
        getK(node1, 3);

    }

    public static int getK(ListNode head, int idx) {
        if (head == null) {
            return 1;
        }
        int k = getK(head.next, idx);
        if (k == idx) {
            System.out.println(head.val);
        }
        return k + 1;
    }
}
