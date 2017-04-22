package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * *  author:jack 2017年04月2017/4/22日
 */
public class LeetCode112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            return help(root, 0, sum);
        } else {
            return false;
        }
    }

    private boolean help(TreeNode root, int sum, int target) {
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = help(root.left, sum, target);
        }
        if (root.right != null) {
            right = help(root.right, sum, target);
        }
        return left || right;
    }
}
