package leetcodedemo.iqiyi;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by jack-pc on 2017/5/14.
 */
//过了60%，其他报错
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int[] nums = new int[n + 5];
        int length = n;
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = 0;
        nums[0] = nums[n + 1] = 1;
        int[] numsSum = new int[n + 5];
        //选出来最大的sum，最小的i
        while (length > 0) {
            int minI = 1;
            int maxSum = nums[0] * nums[1];
            if(2 <= length){
                maxSum *= nums[2];
            }
            for (int i = 1; i <= length; i++) {
                numsSum[i] = nums[i - 1] * nums[i];
                if (i + 1 <= length) {
                    numsSum[i] *= nums[i + 1];
                }
                if (numsSum[i] > maxSum) {
                    minI = i;
                    maxSum = numsSum[i];
                } else if (numsSum[i] == maxSum) {
                    if (nums[i] < nums[minI]) {
                        minI = i;
                    }
                }
            }
            result += numsSum[minI];
            yiwei(nums, minI, length);
            length--;
        }

        System.out.println(result);
    }

    private static void yiwei(int[] nums, int minI, int length) {
        for (int i = minI + 1; i <= length; i++) {
            nums[i - 1] = nums[i];
        }
    }
}
