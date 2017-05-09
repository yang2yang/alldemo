package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack-pc on 2017/5/11.
 */
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        LeetCode114 leetCode114 = new LeetCode114();
        leetCode114.flatten(treeNode);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root);
        root = list.get(0);
        for(int i = 0;i < list.size() - 1;i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    private List<TreeNode> list = new ArrayList<>();

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        help(root.left);
        help(root.right);
    }
}
