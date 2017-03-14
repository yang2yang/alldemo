package leetcodedemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * *  author:jack 2017年02月2017/2/28日
 */
public class LeetCode1 {
    public static void main(String[] args) {
        Integer[] valus = {5, 1, 4, 8};
    }

    //时间复杂度有点高，需要O(n2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] r = new int[2];
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return null;
    }

    //利用hash表，减少查找的时间
    public int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            int left = target - nums[i];
            if(map.containsKey(left)){
                int[] result = new int[2];
                result[0] = i;
                result[1] = (int) map.get(left);
                return result;
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

}
