package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * *  author:jack 2017年04月2017/4/23日
 */
public class LeetCode337 {

    public static void main(String[] args) {

    }

    private Map<TreeNode,Integer> res = new HashMap<>();

    //一个节点所在子树的最大值只有两种情况，一种是包含这个节点的内容，然后加上孙节点的最大值
    //另一种情况是不包含这个节点的内容，两个子节点的最大值之和
    public int rob(TreeNode root) {
        return help(root);
    }


    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(res.containsKey(root)){
            return res.get(root);
        }

        int sum = root.val;

        if (root.left != null) {
            sum += help(root.left.left);
            sum += help(root.left.right);
        }

        if (root.right != null) {
            sum += help(root.right.right);
            sum += help(root.right.left);
        }

        int result = Math.max((help(root.left) + help(root.right)), sum);
        res.put(root,result);
        return result;
    }
}
