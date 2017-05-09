package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/9.
 */
public class LeetCode114_3 {
    public static void main(String[] args) {
        
    }

    public void flatten(TreeNode root) {
        help(root,null);
    }

    private TreeNode help(TreeNode root,TreeNode pre) {
        if(root == null){
            return pre;
        }
        pre = help(root.right,pre);
        pre = help(root.left,pre);
        root.left = null;
        root.right = pre;
        pre = root;
        return pre;
    }
}
