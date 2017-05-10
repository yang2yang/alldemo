package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jack-pc on 2017/5/13.
 */
public class LeetCode103 {
    public static void main(String[] args) {
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List list = levelOrder(root);
        for(int i = 1;i < list.size();i+=2){
            revearseList((List) list.get(i));
        }
        return list;
    }

    private void revearseList(List list) {
        for(int i = 0,j = list.size() - 1;i < j;i++,j--){
            int temp = (Integer) list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
        }
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
