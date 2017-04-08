package leetcodedemo.array;
/**
**  author:jack 2017年04月2017/4/8日
*/
public class LeetCode283 {
    public static void main(String[] args) {
        LeetCode283 leetCode283 = new LeetCode283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        leetCode283.moveZeroes(nums);
        System.out.println(11);
    }

    public void moveZeroes(int[] nums) {
        int count = 1;
        for(int i = nums.length - 1;i >= 0 ;i--){
            if(nums[i] == 0){
                for(int j = i;j < nums.length - count;j++){
                    exchange(nums,j,j+1);
                }
                count++;
            }
        }
    }

    private void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
