package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * *  author:jack 2017年04月2017/4/3日
 */
public class LeetCode404 {

    private int sum = 0;

    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        help(root,false);
        return sum;
    }

    private void help(TreeNode root,Boolean flag) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && flag) {
            sum += root.val;
            return;
        }

        help(root.left,true);
        help(root.right,false);
    }

}
