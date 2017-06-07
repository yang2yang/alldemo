package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/5.
 */
public class LeetCode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxResult = nums[0];
        int maxLocal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(nums[i],maxLocal + nums[i]);
            maxResult = Math.max(maxLocal,maxResult);
        }
        return maxResult;
    }
}
