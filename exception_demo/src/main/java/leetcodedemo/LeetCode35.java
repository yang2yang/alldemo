package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/20日
*/
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums = new int[]{1,2,3,4};
        int target = 5;
        System.out.println(leetCode35.searchInsert(nums,target));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
