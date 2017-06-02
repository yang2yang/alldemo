package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/1.
 */
public class LeetCode565 {
    public static void main(String[] args) {
        int[] abc = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(new LeetCode565().arrayNesting(abc));
    }

    public int arrayNesting(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int count = 0;
                int temp = nums[i];
                nums[i] = -1;
                while (temp != i) {
                    int tt = temp;
                    temp = nums[temp];
                    nums[tt] = -1;
                    count++;
                }
                maxCount = Math.max(maxCount, count + 1);
            }
        }
        return maxCount;
    }

}
