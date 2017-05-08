package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/8.
 */
public class LeetCode129_2 {
    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return help(root,0);
    }

    private int help(TreeNode root,int sum) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 10 * sum + root.val;
        }

        return help(root.left,10 * sum + root.val) + help(root.right,10 * sum + root.val);
    }
}
