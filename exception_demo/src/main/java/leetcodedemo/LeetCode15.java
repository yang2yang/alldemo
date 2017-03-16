package leetcodedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * *  author:jack 2017年03月2017/3/13日
 */
public class LeetCode15 {
    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> rrr = leetCode15.threeSum2(nums);
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                break;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    resultList.add(result);
                    while (nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return resultList;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listListList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!listListList.contains(list)) {
                            listListList.add(list);
                        }
                    }
                }
            }
        }
        return listListList;
    }
}
