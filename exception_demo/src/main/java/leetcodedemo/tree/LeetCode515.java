package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
**  author:jack 2017年03月2017/3/29日
*/
public class LeetCode515 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        LeetCode515 leetCode515 = new LeetCode515();
        leetCode515.largestValues(treeNode);
        for (Integer integer : leetCode515.result) {
            System.out.println(integer);
        }
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        helper(root,1);
        return result;
    }

    private void helper(TreeNode root,Integer deep){
        if(root == null){
            return;
        }

        if(result.size() <= deep - 1){
            result.add(root.val);
        }else{
            result.set(deep - 1,Math.max(result.get(deep - 1),root.val));
        }

        helper(root.left,deep+1);
        helper(root.right,deep+1);
    }
}
