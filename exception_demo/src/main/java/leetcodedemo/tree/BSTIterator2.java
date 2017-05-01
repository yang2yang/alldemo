package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.Stack;

/**
 * Created by jack-pc on 2017/5/1.
 */
public class BSTIterator2 {

    public static void main(String[] args) {

    }

    public Stack<TreeNode> stack = new Stack<>();

    public BSTIterator2(TreeNode root) {

        while (root != null) {
            stack.add(root);
            root = root.left;
        }

    }


    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode treeNode = stack.pop();
        TreeNode root = treeNode.right;
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        return treeNode.val;
    }
}