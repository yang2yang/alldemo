package leetcodedemo.array;

import java.util.Arrays;

/**
 * Created by jack-pc on 2017/6/11.
 */
public class LeetCode153 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,2,3,4};
        LeetCode153 leetCode153 = new LeetCode153();
        System.out.println(leetCode153.findMin(nums));
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] copyNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyNums);
        if(nums[0] == copyNums[0]){
            return nums[0];
        }
        int a = 0;
        int b = nums.length - 1;
        while (true) {
            int mid = (a + b) / 2;
            if (mid == 0) {
                if (nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                } else {
                    a = mid + 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    b = mid - 1;
                }
            } else {
                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                }else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    b = mid - 1;
                }else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    a = mid + 1;
                }else{
                    return nums[mid + 1];
                }

            }
        }
    }

    public int findMin2(int[] nums) {
        int min = nums[0];
        for(int i = 1;i < nums.length;i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }

    public int findMin3(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            //为了不在使用end + start的时候溢出overflow
            int mid = start + (end - start) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}