package offer;

import offer.atwo.three.three.ListNode;

//题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
//照递增排序的。
public class Q25 {
    public static void main(String[] args) {
        ListNode p5 = new ListNode(11, null);
        ListNode p4 = new ListNode(9, p5);
        ListNode p3 = new ListNode(7, p4);
        ListNode p2 = new ListNode(5, p3);
        ListNode list1 = new ListNode(1, p2);

        p5 = new ListNode(14, null);
        p4 = new ListNode(8, p5);
        p3 = new ListNode(7, p4);
        p2 = new ListNode(5, p3);
        ListNode list2 = new ListNode(4, p2);
        MergeSortedLists demo = new MergeSortedLists();

        ListNode list = demo.merge2(list1, list2);
        while (list != null) {
            System.out.print(list.val + " | ");
            list = list.next;
        }
    }
}

class MergeSortedLists {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = merge(list2.next, list1);
            return list2;
        } else {
            list1.next = merge(list1.next, list2);
            return list1;
        }
    }

    public ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode index;
        if (list1.val < list2.val) {
            index = list1;
            list1 = list1.next;
        } else {
            index = list2;
            list2 = list2.next;
        }

        ListNode head = index;
        while (true) {

            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    index.next = list2;
                    list2 = list2.next;
                } else {
                    index.next = list1;
                    list1 = list1.next;
                }
                index = index.next;
                continue;
            }

            if (list1 == null) {
                index.next = list2;
                break;
            }
            index.next = list1;
            break;
        }
        return head;
    }

}
