package leetcodedemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
**  author:jack 2017年03月2017/3/13日
*/
public class LeetCode11 {
    public static void main(String[] args) {
        Integer[] valus = {5,1,4,8};
        twoSum2(valus, 0);
    }

    public static int[] twoSum2(Integer[] nums, int target) {
        List<Integer> vs = Arrays.asList(nums).stream().sorted().collect(Collectors.<Integer>toList());
        vs.stream().forEach((v)->{
            System.out.println(v);
        });
        return null;
    }
}
