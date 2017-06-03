package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/3.
 */
public class LeetCode238 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] ff = new int[nums.length];
        int[] bb = new int[nums.length];
        ff[0] = nums[0];
        for (int i = 1; i < ff.length; i++) {
            ff[i] = ff[i - 1] * nums[i];
        }
        bb[nums.length - 1] = nums[nums.length - 1];
        for (int i = bb.length - 2; i >= 0; i--) {
            bb[i] = bb[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];
        result[0] = bb[1];
        result[nums.length - 1] = ff[nums.length - 2];
        for(int i = 1;i < result.length - 1;i++){
            result[i] = ff[i - 1] * bb[i+1];
        }
        return result;
    }
}
