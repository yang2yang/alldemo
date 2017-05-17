package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/17.
 */
public class LeetCode105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int prefirst, int prelast, int[] inorder, int infirst, int inlast) {
        if (prefirst > prelast) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[prefirst]);
        int i;
        for (i = infirst; i <= inlast; i++) {
            if (inorder[i] == preorder[prefirst]) {
                break;
            }
        }
        int juLi = i - infirst;
        treeNode.left = help(preorder, prefirst + 1, prefirst + juLi, inorder, infirst, i - 1);
        treeNode.right = help(preorder, prefirst + juLi + 1, prelast, inorder, i + 1, inlast);
        return treeNode;
    }
}
