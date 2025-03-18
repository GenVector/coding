package offer;

import offer.atwo.three.three.ListNode;
import tree.btree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 题目：一个链表中包含环，如何找出环的入口结点？
public class Q23 {
}

class EntryNodeInListLoop {
    public static ListNode entryNodeOfLoop(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                ListNode index = head;
                int i = 1;
                head = head.next;
                while (head != index) {
                    head = head.next;
                    i++;
                }
                System.out.println(i);
                return head;
            }
            map.put(head, head);
            head = head.next;
        }
        return null;
    }

    /*
     * 确定链表是否有环，采用快慢指针确定
     * 返回值代表快慢指针相遇时的结点，返回null代表链表无环
     */
    private ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null) {
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
            if (pSlow != null && pSlow == pFast)
                return pSlow;
        }
        return null;
    }

    /**
     * 计算环中入口结点
     */
    public ListNode entryNodeOfLoop2(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        // 计算环中结点的数目
        int count = 1;  //环中结点的数目
        ListNode pNode1 = meetingNode.next;
        while (pNode1 != meetingNode) {
            count++;
            pNode1 = pNode1.next;
        }

        // 先移动pNode1，次数为count
        pNode1 = head;
        for (int i = 1; i <= count; i++) {
            pNode1 = pNode1.next;
        }
        ListNode pNode2 = head;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4))
                .setNext(new ListNode(5)).setNext(new ListNode(6)).setNext(p1.next.next);

        ListNode node = entryNodeOfLoop(p1);
        System.out.println(node.val);
    }

}