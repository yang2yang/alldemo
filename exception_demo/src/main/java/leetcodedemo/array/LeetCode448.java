package leetcodedemo.array;

import java.util.ArrayList;
import java.util.List;

/**
**  author:jack 2017年04月2017/4/7日
*/
public class LeetCode448 {

    public static void main(String[] args) {
        LeetCode448 leetCode448 = new LeetCode448();
        List<Integer> list = leetCode448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        List<Integer> list2 = leetCode448.findDisappearedNumbers(new int[]{1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

}
