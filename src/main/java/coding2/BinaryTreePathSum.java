package coding2;


import tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * 二叉树中找出所有路径，使得路径上的节点值之和等于 21
 * 这个是剪枝法 也可以是个回溯法
 */
public class BinaryTreePathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, sum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // 将当前节点加入路径
        currentPath.add(node.val);

        // 如果当前节点是叶子节点且剩余和等于节点值，则找到一条有效路径
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // 递归遍历左子树和右子树
            dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }

        // 回溯，移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // 构建一个示例二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        BinaryTreePathSum solution = new BinaryTreePathSum();
        List<List<Integer>> paths = solution.pathSum(root, 22);

        // 输出结果
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
/*
                  5
      4                      8
  11     13         13                4
7   2                               5    1

    * 这个是遍历算法
 */

class BinaryTreePathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();
        int sum = 0;
        int index = 22;
        length(root, currentPath, sum, index, allPath);
        for (List<Integer> curr : allPath) {
            for (Integer integer : curr) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    public static int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + Math.max(max(root.left), max(root.right));
    }


    /*
     * 手打
     */
    public static void length(TreeNode root, List<Integer> currentPath, int sum,
                              int index, List<List<Integer>> allPath) {
        currentPath.add(root.val);
        if (sum + root.val == index) {
            allPath.add(new ArrayList<>(currentPath));
            currentPath.remove(root.val);
            return;
        }
        if (root.left == null && root.right == null) {
            currentPath.remove(root.val);
            return;
        }
        if (root.left != null) {
            length(root.left, currentPath, sum + root.val, index, allPath);

        }
        if (root.right != null) {
            length(root.right, currentPath, sum + root.val, index, allPath);
        }
        currentPath.remove(root.val);

    }

}

class BinaryTreePathSum3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();
        int sum = 0;
        int index = 22;
        te(root, currentPath, index, allPath);
        for (List<Integer> curr : allPath) {
            for (Integer integer : curr) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    /*
     * 手打
     */
    public static void te(TreeNode root, List<Integer> currentPath, int currSum, List<List<Integer>> allPath) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (currSum == root.val) {
            allPath.add(new ArrayList<>(currentPath));
            return;
        }

        if (root.left != null) {
            te(root.left, currentPath, currSum - root.val, allPath);
        }
        if (root.right != null) {
            te(root.right, currentPath, currSum - root.val, allPath);
        }

        currentPath.remove(root.val);

    }

}