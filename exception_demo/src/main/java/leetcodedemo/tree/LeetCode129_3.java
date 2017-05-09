package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/8.
 */
public class LeetCode129_3 {
    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return help(root, 0, 0);
    }

    private int help(TreeNode root, int sum, int a) {
        if (root == null) {
            return sum;
        }

        a = a * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += a;
        }
        sum = help(root.left, sum, a);
        sum = help(root.right, sum, a);

        return sum;
    }
}
