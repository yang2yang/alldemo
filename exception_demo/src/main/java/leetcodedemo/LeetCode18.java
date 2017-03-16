package leetcodedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
**  author:jack 2017年03月2017/3/16日
*/
public class LeetCode18 {
    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        int[] nums = new int[]{0,0,0,0};
        leetCode18.fourSum(nums,0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length < 4){
            return resultList;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 3;i++){
            if(i > 0  && nums[i] == nums[i-1]){
                continue;
            }
            for(int m = i+1;m < nums.length - 2;m++){
                if(m > i + 1 && nums[m] == nums[m-1]){
                    continue;
                }
                for (int j = m + 1, k = nums.length - 1; j < k; ) {
                    if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[m]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        resultList.add(result);
                        //感觉精华在这里
                        //这个移动且取值的操作还是有一定危险性的,始终需要判断是j<k,这个是移动的约束条件
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[m] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return resultList;
    }
}
