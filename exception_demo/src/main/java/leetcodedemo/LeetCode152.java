package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/12日
*/
public class LeetCode152 {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[] localMax = new int[nums.length];
        localMax[0] = nums[0];
        int[] localMin = new int[nums.length];
        localMin[0] = nums[0];
        int max = localMax[0];
        for(int i = 1;i < nums.length;i++){
            localMax[i] = Math.max(Math.max(nums[i],nums[i]*localMax[i-1]),nums[i]*localMin[i-1]);
            localMin[i] = Math.min(Math.min(nums[i]*localMin[i-1],nums[i]*localMax[i-1]),nums[i]);
            max = Math.max(localMax[i],max);
        }
        return max;
    }
}
