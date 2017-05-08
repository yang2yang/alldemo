package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/8.
 */
public class LeetCode129 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        LeetCode129 leetCode129 = new LeetCode129();
        leetCode129.sumNumbers(treeNode);
        System.out.println(leetCode129.sum);
    }

    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        help(root,"");
        return sum;
    }

    private void help(TreeNode root,String s) {
        if (root == null) {
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(s);
        }
        help(root.left, s);
        help(root.right, s);
    }
}
