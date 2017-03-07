package leetcodedemo;

import java.util.ArrayList;
import java.util.List;

/**
**  author:jack 2017年03月2017/3/4日
*/
public class LeetCode145 {

    public List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode145 leetcode145 = new LeetCode145();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        List<Integer> re = leetcode145.postorderTraversal(treeNode);
        for(Integer i : re){
            System.out.println(i);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        voidPostorderTraversal(root);
        return result;
    }

    private void voidPostorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }else{
            voidPostorderTraversal(root.left);
            voidPostorderTraversal(root.right);
            result.add(root.val);
        }
    }
}
