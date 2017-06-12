package leetcodedemo.array.DeepFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack-pc on 2017/6/12.
 */
public class LeetCode78 {
    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        leetCode78.subsets(new int[]{1,2,3});
        System.out.println(1111);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        help(nums, 0, new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        return result;
    }

    private void help(int[] nums, int start, List<Integer> list2) {
        for (int i = start; i < nums.length; i++) {
            //保证每一次进入的时候都是list2
            List<Integer> list4 = new ArrayList<>(list2);
            list4.add(nums[i]);
            result.add(list4);
            List<Integer> list3 = new ArrayList<>(list4);
            help(nums, i + 1,list3);
        }
    }
}
