package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/18.
 */
public class LeetCode236 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root, p, q);
    }

    private TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        if (panDuan(root.left, p) && panDuan(root.right, q)) {
            return root;
        }

        if (panDuan(root.right, p) && panDuan(root.left, q)) {
            return root;
        }

        TreeNode a = help(root.left, p, q);
        if (a != null) {
            return a;
        }

        TreeNode b = help(root.right, p, q);
        if (b != null) {
            return b;
        }
        return null;
    }

    private boolean panDuan(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return panDuan(root.left, p) || panDuan(root.right, p);
    }
}
