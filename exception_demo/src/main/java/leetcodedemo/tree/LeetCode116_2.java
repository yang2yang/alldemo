package leetcodedemo.tree;

import leetcodedemo.TreeLinkNode;

/**
 * Created by jack-pc on 2017/5/6.
 */
public class LeetCode116_2 {
    public static void main(String[] args) {

    }

    public void connect(TreeLinkNode root) {
        help(root);
    }

    private void help(TreeLinkNode root) {
        if(root == null){
            return;
        }

        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }

        help(root.left);
        help(root.right);
    }
}
