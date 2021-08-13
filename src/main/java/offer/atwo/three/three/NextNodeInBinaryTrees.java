package offer.atwo.three.three;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class NextNodeInBinaryTrees {
    public static void main(String[] args) {

    }

    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            System.out.print("结点为null ");
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.parent != null) {
            if (pNode == pNode.parent.left) {
                return pNode.parent;
            }
            pNode = pNode.parent;
        }
        return null;
    }
}

