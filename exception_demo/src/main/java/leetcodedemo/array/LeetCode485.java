package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/5/30.
 */
public class LeetCode485 {
    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                count++;
            }else{//only 1 and 0
                max = Math.max(count,max);
                count = 0;
            }
        }
        max = Math.max(count,max);
        return max;
    }
}
