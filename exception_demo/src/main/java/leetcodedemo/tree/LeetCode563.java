package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * *  author:jack 2017年04月2017/4/23日
 */
public class LeetCode563 {
    public static void main(String[] args) {

    }

    int pianyi = 0;

    public int findTilt(TreeNode root) {
        help(root);
        return pianyi;
    }

    private int help(TreeNode root) {
        if (root == null) {
            //考虑清楚这个到底指的是偏移还是指的什么
            //这里返回的应该是子树的和的值
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        pianyi += Math.abs(left - right);
        return left + right + root.val;
    }

}
