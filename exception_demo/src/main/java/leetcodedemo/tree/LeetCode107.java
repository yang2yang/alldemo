package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jack-pc on 2017/5/4.
 */
public class LeetCode107 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        LeetCode107 leetCode107 = new LeetCode107();
        leetCode107.levelOrderBottom(treeNode);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue2.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue2.add(treeNode.right);
            }
            if (queue.isEmpty()) {
                result.add(list);
                list = new ArrayList<>();
                queue = queue2;
                queue2 = new LinkedList<>();
            }
        }

        //反转数组
        List<Integer> temp;
        for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
            temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
        }
        return result;
    }
}
