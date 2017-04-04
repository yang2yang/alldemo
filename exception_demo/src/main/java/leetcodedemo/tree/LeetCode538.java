package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * *  author:jack 2017年04月2017/4/4日
 */
public class LeetCode538 {

    private int sum = 0;

    public static void main(String[] args) {
        LeetCode538 leetCode538 = new LeetCode538();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(-4);
        leetCode538.convertBST(treeNode);
        System.out.println("111");
    }

    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    private void help(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        help(treeNode.right);
        treeNode.val += sum;
        sum = treeNode.val;
        help(treeNode.left);
    }

}
