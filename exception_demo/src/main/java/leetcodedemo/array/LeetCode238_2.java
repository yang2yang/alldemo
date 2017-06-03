package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/3.
 */
public class LeetCode238_2 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp *= nums[i];
        }
        return result;
    }
}
