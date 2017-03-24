package leetcodedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年03月2017/3/23日
*/
public class niukewangyi1701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0,j = nums.length -1;i<j;){
            if(nums[i] < nums[j]){
                nums[i+1] = nums[i] + nums[i+1];
                count++;
                i++;
            }else if(nums[i] > nums[j]){
                nums[j-1] = nums[j-1]+nums[j];
                count++;
                j--;
            }else{
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
