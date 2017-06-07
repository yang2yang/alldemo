package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/7.
 */
public class LeetCode287 {
    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        int[] nums = new int[]{2, 2, 2, 2, 2};
        leetCode287.findDuplicate(nums);
    }

    public int findDuplicate(int[] nums) {
        int min = 1;
        int max = nums.length - 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (mid >= nums[i]) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
