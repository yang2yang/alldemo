package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/15.
 */
public class LeetCode106 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        LeetCode106 leetCode106 = new LeetCode106();
        leetCode106.buildTree(new int[]{1,2},new int[]{1,2});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode treeNode = help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return treeNode;
    }

    private TreeNode help(int[] inorder, int infirst, int inlast, int[] postorder, int postfirst, int postlast) {
        if(infirst > inlast){
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postlast]);
        int i;
        for(i = infirst;i <= inlast;i++){
            if(inorder[i] == postorder[postlast]){
                break;
            }
        }
        int juLi = inlast - i;
        int leftJuLi = i - infirst;
        treeNode.right = help(inorder,i + 1,inlast,postorder,postlast - juLi,postlast - 1);
        treeNode.left = help(inorder,infirst,i - 1,postorder,postfirst,postfirst + leftJuLi - 1);
        return treeNode;
    }
}
