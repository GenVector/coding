package offer;

import tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static tree.btree.TreeNode.newTree1;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/*
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 */
public class Q35 {
}

class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

    private void cloneNodes(RandomListNode head) {
        // 根据原始链表的每个节点 N 创建对应的 N'
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cloned = new RandomListNode(node.label);
            cloned.next = node.next;
            node.next = cloned;
            node = cloned.next;
        }
    }

    private void connectRandomNodes(RandomListNode head) {
        // 设置复制出来的节点的 random
        RandomListNode node = head, cloned;
        while (node != null) {
            cloned = node.next;
            if (node.random != null) {
                cloned.random = node.random.next;
            }
            node = cloned.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode head) {
        // 把这个长链表拆分成两个链表
        RandomListNode node = head, clonedHead = head.next, cloned;
        while (node != null) {
            cloned = node.next;
            node.next = cloned.next;
            if (node.next != null) {
                cloned.next = node.next.next;
            }
            node = node.next;
        }
        return clonedHead;
    }



}