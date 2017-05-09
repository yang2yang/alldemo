package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/11.
 */
public class LeetCode114_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(6);
        LeetCode114_2 leetCode114 = new LeetCode114_2();
        leetCode114.flatten(treeNode);
    }

    public void flatten(TreeNode root) {
        help(root);
    }

    private void  help(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeLeft = root.left;
        TreeNode treeRight = root.right;
        root.left = null;
        help(treeLeft);
        help(treeRight);
        root.right = treeLeft;
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = treeRight;
    }
}