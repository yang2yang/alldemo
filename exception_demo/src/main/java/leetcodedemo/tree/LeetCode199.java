package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jack-pc on 2017/5/2.
 */
public class LeetCode199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> sendQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                sendQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                sendQueue.add(treeNode.right);
            }
            if(queue.isEmpty()){
                list.add(treeNode.val);
                queue = sendQueue;
                sendQueue = new LinkedList<>();
            }
        }
        return list;
    }
}
