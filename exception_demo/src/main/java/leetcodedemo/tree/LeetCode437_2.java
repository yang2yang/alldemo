package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/4.
 */
public class LeetCode437_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);
        treeNode.left.right.right = new TreeNode(1);
        LeetCode437_2 leetCode437_2 = new LeetCode437_2();
        leetCode437_2.pathSum(treeNode,8);
    }

    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        help(root, sum);
        return result;
    }

    private void help(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        result += help2(root, sum, 0);
        help(root.left, sum);
        help(root.right, sum);
    }


    private Integer help2(TreeNode root, int sum, int result) {
        if (root == null) {
            return result;
        }
        if (root.val == sum) {
            result += 1;
            result = help2(root.left, sum - root.val, result);
            result = help2(root.right, sum - root.val, result);
        } else {
            result = help2(root.left, sum - root.val, result);
            result = help2(root.right, sum - root.val, result);
        }
        return result;
    }
}
