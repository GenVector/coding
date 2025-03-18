package offer;

/*
 *题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q8 {

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class NextNodeInBinaryTrees {

    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            throw new RuntimeException("pNode is null");
        }
        //存在右子树,返回右子树的左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        if (pNode.parent == null) {
            return null;
        }
        //是左子树时,直接返回父节点
        if (pNode.parent.left == pNode) {
            return pNode.parent;
        }
        //当它是父节点的右子树,  当父节点是父父节点的左子树时,为下一节点
        if (pNode.parent.right == pNode) {
            TreeLinkNode tem = pNode.parent;
            while (tem.parent != null) {
                if (tem.parent.left == tem) {
                    return tem.parent;
                }
            }
        }

        return null;

    }


    public void test1() {
        TreeLinkNode node = null;
        TreeLinkNode nextNode = getNext(node);
        if (nextNode != null)
            System.out.println(nextNode.val);
        else
            System.out.println("无下一结点");
    }

    public void test2() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.left = node1;
        node1.parent = node4;
        TreeLinkNode nextNodeOf1 = getNext(node1);
        TreeLinkNode nextNodeOf2 = getNext(node2);
        TreeLinkNode nextNodeOf3 = getNext(node3);
        TreeLinkNode nextNodeOf4 = getNext(node4);
        if (nextNodeOf1 != null)
            System.out.println("1结点的下一个结点值为：" + nextNodeOf1.val);
        else
            System.out.println("1结点无下一结点");
        if (nextNodeOf2 != null)
            System.out.println("2结点的下一个结点值为：" + nextNodeOf2.val);
        else
            System.out.println("2结点无下一结点");
        if (nextNodeOf3 != null)
            System.out.println("3结点的下一个结点值为：" + nextNodeOf3.val);
        else
            System.out.println("3结点无下一结点");
        if (nextNodeOf4 != null)
            System.out.println("4结点的下一个结点值为：" + nextNodeOf4.val);
        else
            System.out.println("4结点无下一结点");
    }

    public static void main(String[] args) {
        NextNodeInBinaryTrees demo = new NextNodeInBinaryTrees();
        //System.out.print("test1:");
        //demo.test1();
        System.out.print("test2:");
        demo.test2();
    }
}

