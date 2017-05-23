package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/24.
 */
public class LeetCode222 {

    private int count = 0;

    public int countNodes(TreeNode root) {
        help(root);
        return count;
    }

    private void help(TreeNode root) {
        if(root == null){
            return;
        }
        count++;
        help(root.left);
        help(root.right);
    }
}
