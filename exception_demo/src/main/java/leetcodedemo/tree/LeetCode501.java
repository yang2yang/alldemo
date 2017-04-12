package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ding on 2017/4/11.
 */
public class LeetCode501 {

    public static void main(String[] args) {
        LeetCode501 leetCode501 = new LeetCode501();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(2);
        int[] nums = leetCode501.findMode(treeNode);

        TreeNode tree = new TreeNode(1);
        nums = leetCode501.findMode(tree);
        System.out.println("1");
    }

    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        currentCount = 0;
        maxCount = 0;
        currentVal = root.val;
        help(root);

        if(currentCount == maxCount){
            list.add(currentVal);
        }else if(currentCount > maxCount){
            list.clear();
            list.add(currentVal);
            maxCount = currentCount;
        }

        int[] nums = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    private int currentCount;

    private int currentVal;

    private int maxCount;

    private List<Integer> list = new ArrayList<>();

    private void help(TreeNode root) {
        //如果根节点就是null的时候排除
        if(root == null){
            return;
        }

        if(root.left != null){
            help(root.left);
        }

        if(root.val == currentVal){
            currentCount++;
        }else {
            if(currentCount == maxCount){
                list.add(currentVal);
            }else if(currentCount > maxCount){
                list.clear();
                list.add(currentVal);
                maxCount = currentCount;
            }
            currentCount = 1;
            currentVal = root.val;
        }

        if(root.right != null){
            help(root.right);
        }
    }

}
