package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
**  author:jack 2017年04月2017/4/22日
*/
public class LeetCode112_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        LeetCode112_2 leetcode112_2 = new LeetCode112_2();
        System.out.println(leetcode112_2.hasPathSum(root,2));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return help(root,0,sum);
    }

    private boolean help(TreeNode root, int sum, int target) {
        if(root == null){
            return false;
        }
        sum += root.val;
        if(root.left == null && root.right == null && sum == target){
            return true;
        }
        return help(root.left,sum,target) || help(root.right,sum,target);
    }
}
