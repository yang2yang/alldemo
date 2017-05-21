package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/23.
 */
public class LeetCode236_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        TreeNode p = treeNode.left.left;
        treeNode.left.right = new TreeNode(5);
        TreeNode q = treeNode.left.right;
        LeetCode236_2 leetCode236_2 = new LeetCode236_2();
        leetCode236_2.lowestCommonAncestor(treeNode,p,q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root, p, q);
    }

    private TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root ==  p || root == q){
            return root;
        }
        TreeNode left = help(root.left,p,q);
        TreeNode right = help(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
