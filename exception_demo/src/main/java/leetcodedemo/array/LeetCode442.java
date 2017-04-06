package leetcodedemo.array;

import java.util.ArrayList;
import java.util.List;

/**
**  author:jack 2017年04月2017/4/6日
*/
public class LeetCode442 {
    public static void main(String[] args) {
        LeetCode442 leetCode442 = new LeetCode442();
        List<Integer> list = leetCode442.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        List<Integer> list2 = leetCode442.findDuplicates(new int[]{1});
        System.out.println(111);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                list.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        return list;
    }
}
