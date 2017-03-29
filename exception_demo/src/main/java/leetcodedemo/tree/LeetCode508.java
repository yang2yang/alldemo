package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
**  author:jack 2017年03月2017/3/29日
*/
public class LeetCode508 {

    private Map<Integer,Integer> map = new HashMap();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-5);
        LeetCode508 leetCode508 = new LeetCode508();
        int[] nums = leetCode508.findFrequentTreeSum(treeNode);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        //得到最大的几个值
        int max = Integer.MIN_VALUE;

        for(Integer i:map.values()){
            max = Math.max(max,i);
        }

        List<Integer> list = new ArrayList();
        for(Integer i:map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] numsResult = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            numsResult[i] = list.get(i);
        }

        return numsResult;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        int sum = root.val + leftSum + rightSum;

        if(map.get(sum) == null){
            map.put(sum,1);
        }else{
            map.put(sum,map.get(sum)+1);
        }

        return sum;
    }
}
