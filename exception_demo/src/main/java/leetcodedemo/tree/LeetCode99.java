package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/22.
 */
public class LeetCode99 {
    public static void main(String[] args) {

    }

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        help(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void help(TreeNode root) {
        if(root == null){
            return;
        }

        help(root.left);

        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        help(root.right);
    }
}
