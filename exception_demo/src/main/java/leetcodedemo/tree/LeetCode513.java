package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * *  author:jack 2017年03月2017/3/27日
 */
public class LeetCode513 {

    private int height = 0;

    private int result = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        LeetCode513 leetCode513 = new LeetCode513();
        System.out.println(leetCode513.findBottomLeftValue2(treeNode));
//        leetCode513.findBottomLeftValue2(treeNode);
//        System.out.println(leetCode513.Result);
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode bottomLeftNode = root;
        while (!queue.isEmpty()) {
            int stackSize = queue.size();
            bottomLeftNode = queue.peek();
            for (int i = 0; i < stackSize; i++) {
                TreeNode treeNode = queue.remove();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return bottomLeftNode.val;
    }


    public int findBottomLeftValue2(TreeNode root) {
        helper(root,1);
        return result;
    }

    private void helper(TreeNode root,int deepPath){
        if(root == null){
            return;
        }

        if(deepPath > height){
            result = root.val;
            height = deepPath;
        }

        helper(root.left,deepPath+1);
        helper(root.right,deepPath+1);
    }

}
