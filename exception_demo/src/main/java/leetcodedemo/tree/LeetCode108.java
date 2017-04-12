package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
**  author:jack 2017年04月2017/4/12日
*/
public class LeetCode108 {

    public static void main(String[] args) {
        LeetCode108 leetCode108 = new LeetCode108();
        TreeNode tree = leetCode108.sortedArrayToBST(new int[]{0});
        System.out.println(1);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return help2(nums,0,nums.length-1);
    }

    private TreeNode help(int[] nums,int first,int last){
        if(first > last){
            return null;
        }
        int mid = (first + last) / 2;
        int val = nums[mid];
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = help(nums,first,mid-1);
        treeNode.right = help(nums,mid+1,last);
        return treeNode;
    }

    private TreeNode help2(int[] nums,int first,int last){
        int mid = (first + last) / 2;
        int val = nums[mid];
        TreeNode treeNode = new TreeNode(val);
        if(first <= mid-1){
            treeNode.left = help2(nums,first,mid-1);
        }
        if(mid+1 <= last){
            treeNode.right = help2(nums,mid+1,last);
        }
        return treeNode;
    }
}


