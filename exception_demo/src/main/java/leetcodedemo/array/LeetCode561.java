package leetcodedemo.array;

import java.util.Arrays;

/**
 * Created by jack-pc on 2017/5/29.
 */
public class LeetCode561 {
    public static void main(String[] args) {
        int[] nums =  new int[]{1,4,2,3};
        System.out.println(new LeetCode561().arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
