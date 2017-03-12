package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/7日
*/
public class LeetCode209 {

    public static void main(String[] args) {
        LeetCode209 leetCode209 = new LeetCode209();
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(leetCode209.minSubArrayLen(7,nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0,j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while(j <= nums.length){
            if(sum >= s){
                result = Math.min(result,j - i);
                sum -= nums[i];
                i++;
            }else{
                //最后的临界判断
                if(j == nums.length){
                    break;
                }
                sum += nums[j];
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
