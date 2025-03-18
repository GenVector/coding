package offer;

import offer.atwo.three.three.ListNode;
import org.junit.Test;

/*
 * 删除链表指定节点
 */
public class Q18 {


    /**
     * 删除链表指定节点
     * 删除所有指定节点 可不连续
     */
    public static ListNode del(ListNode head, int node) {
        while (head != null && head.val == node) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 不可能是第一个节点
            if (cur.val == node) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode p1 = new ListNode(1, null);
        p1.setNext(new ListNode(1, null)).setNext(new ListNode(4, null))
                .setNext(new ListNode(1, null)).setNext(new ListNode(3, null))
                .setNext(new ListNode(7, null)).setNext(new ListNode(8, null))
                .setNext(new ListNode(1, null)).setNext(new ListNode(3, null))
                .setNext(new ListNode(1, null)).setNext(new ListNode(6, null));


        ListNode tem = p1;
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
        System.out.println();
        tem = del(p1, 1);
        while (tem != null) {
            System.out.print(tem.val + " | ");
            tem = tem.next;
        }
    }

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
            // 当前节点的值 设置为 下一节点的值
            // 然后手动跳过了下一节点
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
        ListNode p4 = new ListNode(4, null);
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
        ListNode p4 = new ListNode(4, null);
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


