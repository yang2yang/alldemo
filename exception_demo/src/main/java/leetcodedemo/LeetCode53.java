package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/8日
*/
public class LeetCode53 {
    public static void main(String[] args) {

    }

    //暴力穷举
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            int sum = 0;
            for(int j = i;j < nums.length;j++){
                sum += nums[j];
                result = Math.max(result,sum);
            }
        }
        return result;
    }

    //动态规划
    //定义局部最优解  以a[i]结尾的最大的子数组的和  local[i]
    //全局最优解   global = Math.max(global,local[i])
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int global = nums[0];
        int[] local = new int[nums.length];
        local[0] = nums[0];

        for(int i = 1;i < nums.length;i++){
            local[i] = Math.max(local[i-1]+nums[i],nums[i]);
            global = Math.max(global,local[i]);
        }
        return global;
    }
}
