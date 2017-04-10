package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * *  author:jack 2017年04月2017/4/10日
 */
public class LeetCode543 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        LeetCode543 leetCode543 = new LeetCode543();
        int length = leetCode543.diameterOfBinaryTree(t);
        System.out.println(length);
    }

    private int diaMeter = 0;

    //一个节点的左右子树的深度之和加2就可以了，保存最大值
    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return diaMeter;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        int a = 0;
        int b = 0;

        if (root.left != null) {
            a = helphelp(root.left, 0) + 1;
        }
        if (root.right != null) {
            b = helphelp(root.right,0) + 1;
        }

        diaMeter = Math.max(diaMeter,a+b);

        if (root.left != null) {
            help(root.left);
        }

        if (root.right != null) {
            help(root.right);
        }
    }

    private int helphelp(TreeNode tree, int deep) {
        int a = 0;
        int b = 0;
        if (tree.left != null) {
            a = helphelp(tree.left, deep + 1);
        }
        if (tree.right != null) {
            b = helphelp(tree.right, deep + 1);
        }
        return Math.max(deep, Math.max(a, b));
    }
}
