package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/27.
 */
public class LeetCode98 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        LeetCode98 leetCode98 = new LeetCode98();
        leetCode98.isValidBST(treeNode);
    }

    private boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        help(root);
        return flag;
    }

    private Result help(TreeNode root) {
        if (root == null) {
            return null;
        }

        Result leftResult = help(root.left);
        Result rightResult = help(root.right);

        if (leftResult != null && leftResult.max >= root.val) {
            flag = false;
        }

        if (rightResult != null && rightResult.min <= root.val) {
            flag = false;
        }
        Result result = new Result();
        if (leftResult == null) {
            result.min = root.val;
        } else {
            result.min = leftResult.min;
        }
        if (rightResult == null) {
            result.max = root.val;
        } else {
            result.max = rightResult.max;
        }

        return result;

    }
}

class Result {
    public int min;
    public int max;
}