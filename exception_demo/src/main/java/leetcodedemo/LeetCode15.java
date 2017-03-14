package leetcodedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
**  author:jack 2017年03月2017/3/13日
*/
public class LeetCode15 {
    public static void main(String[] args) {

    }


    public List<List<Integer>> threeSum2(int[] nums) {
        return null;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listListList = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                for(int k = j + 1;k < nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if(!listListList.contains(list)){
                            listListList.add(list);
                        }
                    }
                }
            }
        }
        return listListList;
    }
}
