package leetcodedemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * *  author:jack 2017年03月2017/3/5日
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        LeetCode102 leetCode102 = new LeetCode102();
        List<List<Integer>> l = leetCode102.levelOrder(treeNode);
        System.out.println("hello");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //链表阻塞队列
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        List<List<Integer>> list = new ArrayList<>();

        if(root != null){
            queue1.add(root);
        }

        List<Integer> tempList = new ArrayList<>();

        while (!queue1.isEmpty()) {
            TreeNode treeNode = queue1.poll();
            //添加到ArrayList中
            tempList.add(treeNode.val);

            //添加其他节点
            if (treeNode.left != null) {
                queue2.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue2.add(treeNode.right);
            }

            if(queue1.isEmpty()){
                queue1 = queue2;
                list.add(tempList);
                tempList = new ArrayList<>();
                queue2 = new LinkedList<>();
            }
        }

        return list;
    }
}
