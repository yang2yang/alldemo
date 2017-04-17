package leetcodedemo.tree;

/**
 * *  author:jack 2017年04月2017/4/16日
 */
public class LeetCode96 {

    public static void main(String[] args) {
        LeetCode96 leetCode96 = new LeetCode96();
        int what = leetCode96.numTrees(3);
        System.out.println(what);
    }

    public int numTrees(int n) {
        int[] nums = new int[n+5];
        nums[0] = nums[1] = 1;
        for(int i = 2;i < nums.length;i++){
            int sum = 0;
            for(int j = 0;j < i;j++){
                sum += nums[j] * nums[i-j-1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }
}
