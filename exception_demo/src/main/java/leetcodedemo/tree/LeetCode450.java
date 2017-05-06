package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/5.
 */
public class LeetCode450 {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if (root.val == key) {
            if (root.left != null) {
                TreeNode treeNode = getRightNode(root.left);
                treeNode.right = root.right;
                return root.left;
            } else {
                return root.right;
            }
        } else {
            help(root, key);
        }
        return root;
    }

    private void help(TreeNode root, int key) {
        if (root.val > key) {
            if (root.left == null) {
                return;
            }
            if (root.left.val == key) {
                if (root.left.left != null) {
                    TreeNode treeNode = getRightNode(root.left.left);
                    treeNode.right = root.left.right;
                    root.left = root.left.left;
                } else {
                    root.left = root.left.right;
                }
            } else {
                help(root.left, key);
            }
        } else if (root.val < key) {
            if (root.right == null) {
                return;
            }
            if (root.right.val == key) {
                if (root.right.left != null) {
                    TreeNode treeNode = getRightNode(root.right.left);
                    treeNode.right = root.right.right;
                    root.right = root.right.left;
                } else {
                    root.right = root.right.right;
                }
            } else {
                help(root.right, key);
            }
        }
    }

    private TreeNode getRightNode(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }
}
