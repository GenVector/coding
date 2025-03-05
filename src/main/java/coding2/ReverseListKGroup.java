package coding2;

import offer.atwo.three.three.ListNode;

public class ReverseListKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 检查是否有至少 K 个节点
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return head; // 不足 K 个节点，直接返回
            }
            // 分组取到K后的第一个节点 就是下一个分组的头结点
            //
            curr = curr.next;
        }

        // 反转前 K 个节点
        // 将head之后K个节点翻转 得到新的头head
        // newHead 返回 翻转后的头节点
        ListNode newHead = reverse(head, k);

        // 递归处理剩余链表
        head.next = reverseKGroup(curr, k);

        return newHead;
    }

    // 反转链表的前 K 个节点
    // 入参是头节点 将链表翻转之后 返回
    // 比如输入 head = 1->2->3->4 处理为 4->3->2->1 返回 head == 4
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

        int k = 4;
        ReverseListKGroup solution = new ReverseListKGroup();
        ListNode result = solution.reverseKGroup(head, k);

        // 输出结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ReverseListKGroup2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0); // 虚拟头节点
        dummy.next = head;
        ListNode prev = dummy; // 前一组的末尾
        ListNode curr = head; // 当前组的起始

        while (curr != null) {
            // 检查是否有至少 K 个节点
            ListNode tail = curr;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return dummy.next; // 不足 K 个节点，直接返回
                }
                tail = tail.next;
            }

            // 反转当前组
            ListNode[] reversed = reverse(curr, k);
            ListNode newHead = reversed[0];
            ListNode newTail = reversed[1];

            // 连接前一组的末尾和当前组的头
            prev.next = newHead;
            // 连接当前组的末尾和下一组的头
            newTail.next = tail;

            // 更新指针
            prev = newTail;
            curr = tail;
        }

        return dummy.next;
    }

    // 反转链表的前 K 个节点，返回新的头和尾
    private ListNode[] reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, head};
    }

    // 测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ReverseListKGroup2 solution = new ReverseListKGroup2();
        ListNode result = solution.reverseKGroup(head, k);

        // 输出结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}