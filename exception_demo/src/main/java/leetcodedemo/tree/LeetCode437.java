package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/3.
 */
public class LeetCode437 {
    public static void main(String[] args) {

    }

    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        help(root,sum);
        return result;
    }

    private void help(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        result += help2(root, sum);
        help(root.left, sum);
        help(root.right, sum);
    }


    private Integer help2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + help2(root.left, sum - root.val) + help2(root.right, sum - root.val);
        } else {
            return help2(root.left, sum - root.val) + help2(root.right, sum - root.val);
        }
    }
}
