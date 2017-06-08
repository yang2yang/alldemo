package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/8.
 */
public class LeetCode560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = i;j < nums.length;j++){
                int sum = 0;
                for(int m = i;m <= j;m++){
                    sum += nums[m];
                }
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }


    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            int sum = 0;
            for(int j = i;j < nums.length;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
