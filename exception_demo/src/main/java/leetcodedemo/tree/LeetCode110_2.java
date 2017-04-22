package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
**  author:jack 2017年04月2017/4/22日
*/
public class LeetCode110_2 {
    public static void main(String[] args) {
        LeetCode110_2 leetCode110_2 = new LeetCode110_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(leetCode110_2.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return help(root);
    }

    private boolean help(TreeNode root){
        if(root == null){
            return true;
        }

        boolean left = help(root.left);
        boolean right = help(root.right);

        int leftDepth= helpdepth(root.left);
        int rightDepth = helpdepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 && left && right;
    }

    private int helpdepth(TreeNode root){
        if(root == null){
            return -1;
        }
        int leftDepth = helpdepth(root.left);
        int rightDepth = helpdepth(root.right);
        return  Math.max(leftDepth,rightDepth) + 1;
    }

}
