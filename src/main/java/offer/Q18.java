package offer;

import offer.atwo.three.three.ListNode;

/**
 * 删除链表指定节点
 */
public class Q18 {
    public static void main(String[] args) {
        ListNode p4 = new ListNode(4, null);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);

        //ListNode p5 = new ListNode(4, null);
        DeleteNodeInList.deleteNode(p1, p2);

        while (p1 != null) {
            System.out.print(p1.val + " | ");
            p1 = p1.next;
        }
    }
}

//删除链表中的重复节点
class DeleteNodeInList {
    public static void deleteNode(ListNode head, ListNode pToBeDeleted) {
        if (head == null || pToBeDeleted == null) {
            return;
        }
        if (pToBeDeleted.next != null) {
            pToBeDeleted.val = pToBeDeleted.next.val;
            pToBeDeleted.next = pToBeDeleted.next.next;
        } else if (head == pToBeDeleted) {
            //只有一个节点
            head.val = -1;
        } else {
            //尾结点
            ListNode node = head;
            while (node.next != null && node.next != pToBeDeleted) {
                node = node.next;
            }
            if (node.next != null) {
                node.next = null;
            }
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = pHead;
        ListNode pre = null;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                if (pre == null) {
                    pHead = cur;
                } else {
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;

            }
        }
        return pHead;
    }

    public static void t2() {
        ListNode p4 = new ListNode(4, null);
        ListNode p41 = new ListNode(4, p4);
        ListNode p3 = new ListNode(3, p41);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);


        ListNode tem = p1;
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
        System.out.println();
        tem = deleteDuplication(p1);
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
    }

    public static void t1() {
        ListNode p3 = new ListNode(1, null);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(1, p2);


        ListNode tem = p1;
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
        System.out.println();
        tem = deleteDuplication(p1);
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
    }

    public static void t3() {
        ListNode p4 = new ListNode(4,null);
        ListNode p3 = new ListNode(1, p4);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(1, p2);



        ListNode tem = p1;
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
        System.out.println();
        tem = deleteDuplication(p1);
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
    }

    public static void t4() {
        ListNode p4 = new ListNode(4,null);
        ListNode p3 = new ListNode(1, p4);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(2, p2);



        ListNode tem = p1;
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
        System.out.println();
        tem = deleteDuplication(p1);
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
    }

    public static void main(String[] args) {
        t4();
        System.out.println();
        t3();
        System.out.println();
        t2();
        System.out.println();
        t1();
    }
}


