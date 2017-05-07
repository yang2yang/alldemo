package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/8.
 */
public class LeetCode572 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);

        LeetCode572 leetCode572 = new LeetCode572();
        System.out.println(leetCode572.isSubtree(treeNode, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return help(s, t);
    }

    private boolean help(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if(helphelp(s,t)){
            return true;
        }
        return help(s.left, t) || help(s.right, t);
    }

    private boolean helphelp(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return helphelp(s.left, t.left) && helphelp(s.right, t.right);
    }
}
