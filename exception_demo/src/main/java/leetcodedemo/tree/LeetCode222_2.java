package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/24.
 */
public class LeetCode222_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        LeetCode222_2 leetCode222_2 = new LeetCode222_2();
        leetCode222_2.countNodes(treeNode);
    }

    public int countNodes(TreeNode root) {
        return help(root, -1, -1);
    }

    private int help(TreeNode root, int leftHeight, int rightHeight) {
        if (root == null) {
            return 0;
        }
        TreeNode leftRoot = root;
        TreeNode rightRoot = root;
        if (leftHeight == -1) {
            leftHeight = 0;
            while (leftRoot != null) {
                leftHeight++;
                leftRoot = leftRoot.left;
            }
        }

        if (rightHeight == -1) {
            rightHeight = 0;
            while (rightRoot != null) {
                rightHeight++;
                rightRoot = rightRoot.right;
            }
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return help(root.left, leftHeight, -1) + help(root.right, -1, rightHeight) + 1;
    }

}
